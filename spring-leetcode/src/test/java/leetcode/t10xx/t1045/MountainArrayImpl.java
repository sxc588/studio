package leetcode.t10xx.t1045;

public class MountainArrayImpl implements MountainArray {

	private int[] aray = null;

	public MountainArrayImpl(int... aray) {
		super();
		this.aray = aray;
	}

	@Override
	public int get(int index) {
		return aray[index];
	}

	@Override
	public int length() {
		return aray.length;
	}
}
