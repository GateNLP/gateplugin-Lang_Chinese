package chinese;
import gate.creole.ResourceReference;
import gate.creole.Transducer;
import gate.creole.metadata.CreoleParameter;
import gate.creole.metadata.CreoleResource;

@CreoleResource(name="Chinese Inferred Grammar")
public class ChineseInferredTransducer extends Transducer {

  private static final long serialVersionUID = -7947260729469194393L;

  @Override
  @CreoleParameter(defaultValue="resources/inferred-grammar/main.jape")
  public void setGrammarURL(ResourceReference grammar) {
    super.setGrammarURL(grammar);
  }
}