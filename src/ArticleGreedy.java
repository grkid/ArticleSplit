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

            //only when a single line cannot handle one word should i split it
            if(line.length()+1+splitText[i].length()>=maxLineLength)
            {
                if(splitText[i].length()<maxLineLength)
                {
                    lineText.add(line);
                    line=splitText[i];
                }
                else {
                    int bias = maxLineLength - 2 - line.length();//space remain
                    boolean biasFlag=false;
                    if (bias == 0) {
                        lineText.add(line);
                       line="";
                       bias=maxLineLength-1;
                       biasFlag=true;
                    }
                    line += biasFlag?"":" " + (splitText[i].substring(0, bias));
                    splitText[i] = splitText[i].substring(bias);
                    lineText.add(line);
                    line = "";
                    i--;
                }
            }
//            else if(line.length()+splitText[i].length()+1 > maxLineLength)
//            {
//                lineText.add(line);
//                line=splitText[i];
//            }
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
