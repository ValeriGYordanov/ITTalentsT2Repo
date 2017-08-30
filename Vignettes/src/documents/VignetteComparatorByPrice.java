package documents;

import java.util.Comparator;

public class VignetteComparatorByPrice implements Comparator<Vignette> {

	@Override
	public int compare(Vignette o1, Vignette o2) {
		//public int compare(final Vignette o1,Vignette o2) {
		//TODO	return 1 if o2 should be before o1
		//		return -1 if o1 should be before o2
		//		otherwise return 0;
		if (o1.getPrice() < o2.getPrice()) {
			return -1;
		}
		else if(o1.getPrice() > o2.getPrice()) {
			return 1;
		}
		else {
			return 0;
		}
	}

}
