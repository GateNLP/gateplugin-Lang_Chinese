package chinese;
import gate.creole.ResourceReference;
import gate.creole.gazetteer.DefaultGazetteer;
import gate.creole.metadata.CreoleParameter;
import gate.creole.metadata.CreoleResource;

@CreoleResource(name="Chinese Numbers Gazetteer")
public class NumbersGazetteer extends DefaultGazetteer {
  
  private static final long serialVersionUID = 4104008795796991482L;

  @Override
  @CreoleParameter(defaultValue="resources/gazetteer/numbers_list.def")
  public void setListsURL(ResourceReference lists) {
    super.setListsURL(lists);
  }
  
  @Override
  @CreoleParameter(defaultValue="false")
  public void setWholeWordsOnly(Boolean wholeWordsOnly) {
    super.setWholeWordsOnly(wholeWordsOnly);
  }
}