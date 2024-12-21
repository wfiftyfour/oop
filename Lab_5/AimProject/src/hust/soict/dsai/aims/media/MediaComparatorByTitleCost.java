package hust.soict.dsai.aims.media;

import java.util.Comparator;

public class MediaComparatorByTitleCost implements Comparator<Media>{

	@Override
	public int compare(Media o1, Media o2) {
		// TODO Auto-generated method stub
		float x=o1.cost-o2.cost;
		if(o1.title.compareTo(o2.title)==0)
			return (int)x;
		else return o1.title.compareTo(o2.title);
	}
	

}
