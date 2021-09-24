/**
 * @author DzcGood
 * @date 2021/9/10 - 16:03
 */


public class StringExer {
    /*
    * 获取一个字符串在另一个字符串中出现的次数
    * */
    public int getCount(String mainStr, String subStr){
        int mainLen = mainStr.length();
        int subLen = subStr.length();
        if(mainLen < subLen){
            return 0;
        }
        int count = 0;
        int index = 0;
        /*
        * 使用indexOf方法，若上一次目标字符串出现的位置为index，则
        * 下一次从index + subLen开始找，直到indexOf返回-1为止
        * */
        while((index = mainStr.indexOf(subStr, index)) != -1){
            count++;
            index +=subLen;
        }
        return count;
    }

    /*
    * 获取两个字符串中的最大相同字串
    * 目前假设只有一个最大相同子串，之后讲到集合的时候，可以改进
    * 思路：将短的字符串进行长度依次递减的字串与较长的字串比较
    * */
    public String getMaxSameString(String str1, String str2){
        if(str1 == null || str2 == null){
            return null;
        }
        String maxStr = (str1.length() >= str2.length()) ? str1 : str2;
        String minStr = (str1.length() < str2.length()) ? str1 : str2;
        int len = minStr.length();
        //滑动窗口法
        for (int i = 0; i < len ; i++) {
            for(int start = 0, end = len - i; end <= len; start++, end++){//关键点
                String subStr = minStr.substring(start, end);
                if(maxStr.contains(subStr)){
                    return subStr;
                }
            }
        }
        return null;
    }
}
