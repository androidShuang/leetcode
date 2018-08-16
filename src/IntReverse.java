public class IntReverse {
    public int reverse(int x) {
        int rever = 0;
        while(x!=0){
            int pop = x%10;
            x/=10;
            //判断溢出
            if(rever>Integer.MAX_VALUE/10||(rever==Integer.MAX_VALUE/10&&pop>7)){
                return 0;
            }
            if(rever<Integer.MIN_VALUE/10||(rever==Integer.MIN_VALUE/10&&pop<-8)){
                return 0;
            }
            int temp = rever*10+pop;
            rever = temp;
        }
        return rever;
    }
}
