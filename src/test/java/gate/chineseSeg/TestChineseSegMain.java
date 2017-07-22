/*
 *  TestChineseSegMain.java
 *
 *  Yaoyong Li 23/04/2009
 *
 *  $Id: TestChineseSegMain.java 20109 2017-02-13 22:02:05Z markagreenwood $
 */

package gate.chineseSeg;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;

import org.apache.commons.io.FileUtils;

import gate.Factory;
import gate.FeatureMap;
import gate.Gate;
import gate.GateConstants;
import gate.test.GATEPluginTestCase;
import gate.util.BomStrippingInputStreamReader;
import gate.util.Files;

public class TestChineseSegMain extends GATEPluginTestCase {

  /** Learning home for reading the data and configuration file. */
  private static File bdmPluginHome;

  @Override
  public void setUp() throws Exception {
    super.setUp();
    
    bdmPluginHome = Files.fileFromURL(this.getClass().getResource("/test/")).getParentFile();
  }

  /** The test the IAA. */
  public void testChineseSegMain() throws Exception {

    Boolean savedSpaceSetting = Gate.getUserConfig().getBoolean(
            GateConstants.DOCUMENT_ADD_SPACE_ON_UNPACK_FEATURE_NAME);
    Gate.getUserConfig().put(
            GateConstants.DOCUMENT_ADD_SPACE_ON_UNPACK_FEATURE_NAME,
            Boolean.FALSE);
    
    File modelDir = null;
    
    try {      
      String corpusDirName;
      corpusDirName = new File(bdmPluginHome, "test").getAbsolutePath();

      ChineseSegMain chineseSeg = null;

      FeatureMap parameters = Factory.newFeatureMap();

      chineseSeg = (ChineseSegMain)Factory.createResource(
        "gate.chineseSeg.ChineseSegMain", parameters);

      File trainData = new File(corpusDirName, "trainingData-utf8");
      modelDir = new File(corpusDirName, "model-utf8");
      File testData = new File(corpusDirName, "testData-utf8");

      chineseSeg.setModelURL(modelDir.toURI().toURL());
      chineseSeg.setTextFilesURL(trainData.toURI().toURL());
      chineseSeg.setLearningMode(RunMode.LEARNING);

      chineseSeg.setTextCode("UTF-8");
      chineseSeg.setLearningAlg("PAUM");

      //The controller include the segmenter as one PR.
      gate.creole.SerialController
      controller = (gate.creole.SerialController)Factory
      .createResource("gate.creole.SerialController");
      //controller.setCorpus(data);
      controller.add(chineseSeg);

      //System.out.println("starting executing...");
      //learning ...
      emptySavedFiles(modelDir); //remove the model files
      controller.execute();

      //Application
      chineseSeg.setTextFilesURL(testData.toURI().toURL());
      chineseSeg.setLearningMode(RunMode.SEGMENTING);

      controller.execute();

      BufferedReader inSegText = null;
      inSegText = new BomStrippingInputStreamReader(
          new FileInputStream(new File(new File(testData, ConstantParameters.FILENAME_resultsDir),
            "doc-utf8.txt.seg.txt")), "UTF-8");

      for(int i=0; i<14; ++i)
        inSegText.readLine();

      String lastLine = inSegText.readLine();

      inSegText.close();

      char[] chs  = new char[17];

      for(int i=0; i<17; ++i) {
        chs[i] = lastLine.charAt(i);
        //System.out.println("i="+i+", ch="+chs[i]+"*");
      }
      
      System.out.println("1="+chs[2]+", 2="+chs[4]+", 3="+chs[8]+", 4="+chs[14]+".");
      
      //System.out.println("1="+nPwF[0]+", 2="+nPwF[1]+", 3="+nPwF[2]+", 4="+nPwF[3]+".");
      assertEquals("Wrong value for correct: ", ConstantParameters.SEPARATTOR_BLANK, chs[2]);
      assertEquals("Wrong value for correct: ", '9', chs[4]);
      assertEquals("Wrong value for correct: ", ConstantParameters.SEPARATTOR_BLANK, chs[8]);
      assertEquals("Wrong value for correct: ", ConstantParameters.SEPARATTOR_BLANK, chs[14]);
      
      FileUtils.deleteDirectory(new File(testData, ConstantParameters.FILENAME_resultsDir));

    }
    finally {
      Gate.getUserConfig().put(
              GateConstants.DOCUMENT_ADD_SPACE_ON_UNPACK_FEATURE_NAME,
              savedSpaceSetting);
    }

  }

  private void emptySavedFiles(File savedFilesDir) throws IOException {
    (new File(savedFilesDir, ConstantParameters.FILENAME_TERMS)).delete();
    (new File(savedFilesDir, ConstantParameters.FILENAMEOFLabelList)).delete();
    (new File(savedFilesDir, ConstantParameters.FILENAMEOFLOGFILE)).delete();
    (new File(savedFilesDir, ConstantParameters.FILENAMEOFFeatureVectorData)).delete();
    FileUtils.deleteDirectory(new File(savedFilesDir, ConstantParameters.FILENAMEOFModels));
  }
}
