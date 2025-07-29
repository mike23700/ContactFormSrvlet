package com.filters;

import javax.servlet.*;
import java.io.IOException;
import java.util.*;

public class BadWordsFilter implements Filter {

    private final List<String> bannedWords = Arrays.asList(
            "nigga", "dumb ass", "fuck", "shit", "bastard", "asshole", "SAND", "suck-it", "b*tch"
    );

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        String message = request.getParameter("message");
        List<String> foundWords = new ArrayList<>();

        if (message != null) {
            String lowerCaseMessage = message.toLowerCase();
            for (String word : bannedWords) {
                if (lowerCaseMessage.contains(word)) {
                    foundWords.add(word);
                }
            }
        }

        if (!foundWords.isEmpty()) {
            response.setContentType("text/html;charset=UTF-8");
            response.getWriter().println("<h2>⚠️ Le message contient des mots interdits :</h2>");
            response.getWriter().println("<ul>");
            for (String word : foundWords) {
                response.getWriter().println("<li style='color:red;'>" + word + "</li>");
            }
            response.getWriter().println("</ul>");
            return;
        }

        chain.doFilter(request, response);
    }

    @Override
    public void init(FilterConfig filterConfig) {}
    @Override
    public void destroy() {}
}
