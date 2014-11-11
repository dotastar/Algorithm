package com.fb;

/**
 * Give you  a function char* read4096(), return a string which has <= 4096 characters
 *
 * If the string less than 4096 characters which means reached the end of file ”
 *
 * Use API read4096(), write a function char* readline()
 *
 * Requirement:
 * #1 readline() returns when reading ‘\n’ or ”;
 * #2 readline() may be called multiple times on a file, the return value  should be correct.
 * #3 readline() may return char array longer than 4096 chars.
 *
 */
public class ReadLine {
    String buffer = null;
    int p = 0;

    /**
     * Reference: http://weidw.wordpress.com/2012/05/03/use-read4096-implement-readlin/
     *
     */
    public String readLine(){
        StringBuilder result = new StringBuilder();
        boolean EOF = false;
        while(true){
            if(!EOF){
                if(buffer == null || p == buffer.length()){
                    buffer = read4096();
                    p = 0;
                    if(buffer.length() < 4096) EOF = true;
                }else{
                    int i;
                    for(i = p; i < buffer.length(); i++){
                        if(buffer.charAt(i) == '\0' || buffer.charAt(i) == '\n') break;
                    }
                    int oldSize = result.length();
                    result.append(buffer.substring(p, i + 1));
                    p = i + 1;
                    if(i != buffer.length()) break;
                }

            }
        }
        return result.toString();
    }

    public String read4096(){
        //given implement
        return "";
    }
}
