package chinese;
import gate.creole.ResourceReference;
import gate.creole.Transducer;
import gate.creole.metadata.CreoleParameter;
import gate.creole.metadata.CreoleResource;

@CreoleResource(name="Split Chinese Digits")
public class ChineseSplitTransducer extends Transducer {

  private static final long serialVersionUID = 5640603542343072267L;

  @Override
  @CreoleParameter(defaultValue="resources/tokeniser/split_digits.jape")
  public void setGrammarURL(ResourceReference grammar) {
    super.setGrammarURL(grammar);
  }
}