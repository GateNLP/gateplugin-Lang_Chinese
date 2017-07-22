package chinese;
import gate.creole.ResourceReference;
import gate.creole.gazetteer.DefaultGazetteer;
import gate.creole.metadata.CreoleParameter;
import gate.creole.metadata.CreoleResource;

@CreoleResource(name="Chinese Special Gazetteer")
public class SpecialGazetteer extends DefaultGazetteer {
  
  private static final long serialVersionUID = 5740300075867634317L;

  @Override
  @CreoleParameter(defaultValue="resources/gazetteer/special_lists.def")
  public void setListsURL(ResourceReference lists) {
    super.setListsURL(lists);
  }
  
  @Override
  @CreoleParameter(defaultValue="false")
  public void setWholeWordsOnly(Boolean wholeWordsOnly) {
    super.setWholeWordsOnly(wholeWordsOnly);
  }
}