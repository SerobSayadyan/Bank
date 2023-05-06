package bankProject.validation;

import java.net.URL;

/**
 * A valid URL must consist of the following:
 *      (ex. https://example.com/path)
 *      - protocol (ex. http://, https:// etc.);
 *      - domain (ex. example.com);
 *      - path (ex. /path/)
 */

public class URLValidation {
    public boolean isURLValid(String url) {
        try {
            new URL(url).toURI();
            return true;

        } catch (Exception e) {
            return false;
        }
    }
}
