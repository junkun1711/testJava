package com.test;

public class TestBytes {
	private static boolean isCheckBox = false;

	public static void main(String[] args) {
		String s = "QAAA";
		byte[] bb = s.getBytes();
		Bitset validFor = new Bitset(bb);
		if (!isCheckBox) {
			// if the controller is a picklist, list all
			// controlling values for which this entry is valid
			for (int k = 0; k < validFor.size(); k++) {
				if (validFor.testBit(k)) {
					// if bit k is set, this entry is valid for the
					// for the controlling entry at index k
					// System.out.println(controller.getPicklistValues()[k].getLabel());

					System.out.println("index" + k);
				}
			}
		} else if (isCheckBox) {
			// the controller is a checkbox
			// if bit 1 is set this entry is valid if the controller is checked
			if (validFor.testBit(1)) {
				System.out.println(" checked");
			}
			// if bit 0 is set this entry is valid if the controller is not
			// checked
			if (validFor.testBit(0)) {
				System.out.println(" unchecked");
			}
		}
	}

	public static class Bitset {
		byte[] data;

		public Bitset(byte[] data) {
			this.data = data == null ? new byte[0] : data;
		}

		public boolean testBit(int n) {
			return (data[n >> 3] & (0x80 >> n % 8)) != 0;
		}

		public int size() {
			return data.length * 8;
		}
	}
}
