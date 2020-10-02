public class ArticleController {
    private String text;
    private String type;
    private String bubble;
    private String result;
    public ArticleController(String text,int lineLength,String type,String bubble)
    {
        //split greedy output
        ArticleSplit s=new ArticleSplit(text);
        ArticleGreedy g=new ArticleGreedy(s.getResult(),lineLength);
        ArticleOutput o=new ArticleOutput(g.getResult(),lineLength,type,bubble);
        result=o.getResult();
    }

    public String getResult()
    {
        return this.result;
    }
}
