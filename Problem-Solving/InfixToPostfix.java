import java.util.*;

public class InfixToPostfix {
	public static void main(String[] args) {
	}
	public static String getPostFix(String s) {
		StringBuilder sb = new StringBuilder();
		Stack<Character> st = new Stack<>();
		for(int i=0; i<s.length(); i++) {
			char ch = s.charAt(i);
			if(ch >= '0' && ch<='9') {
				sb.append(ch);
			}else if(ch=='('){
				st.push(ch);
			}else if(ch == ')') {
				while(st.peek()!='(') {
					sb.append(st.pop());
				}
				st.pop();
			}else {
				while(!st.isEmpty() && getValue(st.peek()) > getValue(ch)) {
					sb.append(st.pop());
				}
				st.push(ch);
			}
		}
		return st.toString();
	}
	public static int getValue(char ch) {
		if(ch == '*' || ch == '/') {
			return 2;
		}else if(ch == '-' || ch == '+') {
			return 1;
		}else {
			return -1;
		}
	}

}