package com.works.dataStructures.album;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Album {
	private int minImage = 0;
	private int maxImage = 10;

	public int[] getImageRepeated(int[] array) {

		int[] repeated = new int[array.length];

		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length; j++) {
				if (!(i == j)) {
					if (array[i] == array[j]) {
						repeated[i] = array[i];
						array[j] = 0;
					}
				}
			}

		}
		return repeated;
	}
}
