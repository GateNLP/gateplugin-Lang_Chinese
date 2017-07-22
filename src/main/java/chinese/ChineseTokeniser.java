package chinese;

import gate.creole.ResourceReference;
import gate.creole.metadata.CreoleParameter;
import gate.creole.metadata.CreoleResource;
import gate.creole.tokeniser.SimpleTokeniser;

@CreoleResource(name="Chinese Tokeniser")
public class ChineseTokeniser extends SimpleTokeniser {

  private static final long serialVersionUID = 5091537024462629276L;

  @Override
  @CreoleParameter(defaultValue="resources/tokeniser/chineseTokeniser.rules")
  public void setRulesURL(ResourceReference rules) {
    super.setRulesURL(rules);
  }
}