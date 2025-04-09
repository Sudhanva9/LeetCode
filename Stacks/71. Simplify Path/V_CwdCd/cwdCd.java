class Solution {

  public String simplifyPath(String cwd, String cd) {

    if (cd.isEmpty()) return cwd;
    
    if (cd.charAt(0) == '/') {
        cwd = ""; // Treat absolute path as starting from root
    }

    Stack<String> stack = new Stack<>();

    // Step 1: Parse and push cwd to the stack
    String[] cwdParts = cwd.split("/");
    for (String part : cwdParts) {
        if (!part.isEmpty()) {
            stack.push(part);
        }
    }

    // Step 2: Apply cd
    String[] cdParts = cd.split("/");
    for (String cur : cdParts) {
        if (cur.equals("..")) {
            if (!stack.isEmpty()) stack.pop();
        } else if (!cur.equals("") && !cur.equals(".")) {
            stack.push(cur);
        }
    }

    // Handle the case for the root directory
    if (stack.isEmpty()) {
        return "/";
    }

    // Join stack into path and return
    return "/" + String.join("/", stack);
}

}
