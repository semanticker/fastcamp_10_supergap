package org.example.mvc.view;

import static org.example.mvc.view.RedirectView.PREFIX_REDIRECT_DEFAULT;
public class JspViewResolver implements ViewResolver {
    @Override
    public View resolveView(String viewName) {
        if (viewName.startsWith(PREFIX_REDIRECT_DEFAULT)) {
            return new RedirectView(viewName);
        }
        return new JspView(viewName + ".jsp");
    }
}
