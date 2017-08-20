package servlet.util.bundle;

import java.util.Locale;
import java.util.ResourceBundle;

public class RuBundle implements BundleFactory {

    @Override
    public ResourceBundle makeBundle() {
	return ResourceBundle.getBundle("product_list_ru", new Locale("ru", "RU"));
    }
}
