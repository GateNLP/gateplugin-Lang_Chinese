package chinese;
import gate.creole.ResourceReference;
import gate.creole.gazetteer.DefaultGazetteer;
import gate.creole.metadata.CreoleParameter;
import gate.creole.metadata.CreoleResource;

@CreoleResource(name="Chinese Gazetteer")
public class ChineseGazetteer extends DefaultGazetteer {

  private static final long serialVersionUID = 1160031650794294612L;

  @Override
  @CreoleParameter(defaultValue="resources/gazetteer/numbers_list.def")
  public void setListsURL(ResourceReference lists) {
    super.setListsURL(lists);
  }
}