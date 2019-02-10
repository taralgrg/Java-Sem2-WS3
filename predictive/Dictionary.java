package predictive;
import java.util.Set;

/**
 * The interface Dictionary implements the signatureToWords method.
 */
public interface Dictionary{
    public Set<String> signatureToWords(String signature);
}