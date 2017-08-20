package servlet.util.bundle;

import java.util.Locale;
import java.util.ResourceBundle;

public class EnBundle implements BundleFactory {

    @Override
    public ResourceBundle makeBundle() {
	return ResourceBundle.getBundle("product_list_en", new Locale("en", "GB"));
    }
}
