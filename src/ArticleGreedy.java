import java.util.Vector;

public class ArticleGreedy {

    private String[] splitText;
    private int maxLineLength;
    private Vector<String> lineText=new Vector<String>();

    public ArticleGreedy(String[] splitText,int lineLength)
    {
        this.splitText=splitText;
        this.maxLineLength=lineLength;
    }

    private void solve()
    {
        String line="";
        for(int i=0;i<splitText.length;i++)
        {
            //< line length

            //corner case
            if(line.length()+1+splitText[i].length()>=maxLineLength)
            {
                lineText.add(splitText[i].substring(0,maxLineLength-2-line.length()));
                //caution. -2 instead of -1
                splitText[i]=splitText[i].substring(maxLineLength-1-line.length());
                i--;
            }
            else if(line.length()+splitText[i].length()+1 > maxLineLength)
            {
                lineText.add(line);
                line="";
            }
            else
            {
                line+=(line.length()==0?"":" ")+splitText[i];
            }
        }
        lineText.add(line);
    }

    public Vector<String> getResult()
    {
        solve();
        return lineText;
    }
}
