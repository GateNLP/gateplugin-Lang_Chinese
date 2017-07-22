package chinese;
import gate.creole.ResourceReference;
import gate.creole.gazetteer.DefaultGazetteer;
import gate.creole.metadata.CreoleParameter;
import gate.creole.metadata.CreoleResource;

@CreoleResource(name="Chinese Inferred Gazetteer")
public class InferredGazetteer extends DefaultGazetteer {
  
  private static final long serialVersionUID = 5763547487693390879L;

  @Override
  @CreoleParameter(defaultValue="resources/inferred-gazetteer/lists.def")
  public void setListsURL(ResourceReference lists) {
    super.setListsURL(lists);
  }
}