import java.util.Arrays;
import java.util.Vector;

public class ArticleSplit {
    String originalText;
    String[] splitText;

    //do split, text may not be formatted.

    public ArticleSplit(String text)
    {
        this.originalText=text;
    }

    public boolean isAlphabet(char a)
    {
        if(a>='a'&&a<='z')
            return true;
        if(a>='0'&&a<='9')
            return true;
        return a >= 'A' && a <= 'Z';
    }

    private String[] singleSplit(String a)
    {
        Vector<String> res=new Vector<String>();

        int begin=0;
        int end=0;
        for(int i = 0; i< a.length(); i++)
        {
            end=i;
            if(!isAlphabet(a.charAt(i))) {
                if(a.charAt(i)!='\'')
                {
                    res.add(a.substring(begin, end));

                    if(begin==0&&end==0) {
                        res.set(res.size()-1,a.substring(0,1));
                        //corner case
                    }
                    begin = i;
                }
            }
        }
        res.add(a.substring(begin,a.length()));

        return (String[])res.toArray(new String[res.size()]);
    }

    public void solve()
    {
        //首先，按照空格分词
        //假如存在单个标点作为string，附着到前一个上
        //假如存在某个string中存在标点，再做分割
        //上面两条顺序互换
        String[] texts=originalText.split(" +");
        Vector<String> stashText=new Vector<String>();
        for (String text : texts) {
            String[] temp = singleSplit(text);
            for (String subStr : temp) {
                if (subStr.length() == 1 && !isAlphabet(subStr.charAt(0))) {
                    if (stashText.isEmpty())
                        stashText.add("");
                    stashText.set(stashText.size() - 1, stashText.lastElement() + subStr);
                }
                else
                    stashText.add(subStr);
            }
        }
        splitText=(String[])stashText.toArray(new String[stashText.size()]);
    }

    public String[] getResult()
    {
        solve();
        return this.splitText;
    }
}
