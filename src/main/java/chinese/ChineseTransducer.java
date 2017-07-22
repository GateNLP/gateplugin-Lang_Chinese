package chinese;
import gate.creole.ResourceReference;
import gate.creole.Transducer;
import gate.creole.metadata.CreoleParameter;
import gate.creole.metadata.CreoleResource;

@CreoleResource(name="Chinese NE Grammar")
public class ChineseTransducer extends Transducer {
  
  private static final long serialVersionUID = -6637580335275914281L;

  @Override
  @CreoleParameter(defaultValue="resources/grammar/main.jape")
  public void setGrammarURL(ResourceReference grammar) {
    super.setGrammarURL(grammar);
  }
}