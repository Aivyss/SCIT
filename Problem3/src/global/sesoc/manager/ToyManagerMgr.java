package global.sesoc.manager;

import java.util.ArrayList;
import java.util.List;

import global.sesoc.vo.Bicycle;
import global.sesoc.vo.Drone;
import global.sesoc.vo.GameConsole;
import global.sesoc.vo.Toy;

public class ToyManagerMgr implements ToyManager {
	private List<Toy> toyList; // 각종 Toy 정보를 담을 리스트

	/**
	 * Constructor
	 */
	public ToyManagerMgr() {
		this.toyList = new ArrayList<>();
	}

	@Override
	public Toy searchToy(String serialNum) {
		Toy toy = null;

		if (toyList != null || !toyList.isEmpty()) {
			for (Toy vo : toyList) {
				if (serialNum.equals(vo.getSerialNum())) {
					toy = vo;
				}
			}
		}

		return toy;
	}

	@Override
	public boolean insertToy(Toy toy) {
		boolean flag = true;

		if (toy != null && this.toyList != null && !this.toyList.isEmpty()) {
			for (Toy vo : toyList) {
				if (toy.getSerialNum().equals(vo.getSerialNum())) {
					flag = false;
					break;
				}
			}
		} else if (toy == null) {
			flag = false;
		}

		if (flag) {
			this.toyList.add(toy);
		}

		return flag; // true --> success
	}

	@Override
	public boolean deleteToy(String serialNum) {
		boolean flag = false;

		if (this.toyList != null || !this.toyList.isEmpty()) {
			int index = 0;

			for (Toy vo : toyList) {
				if (serialNum.equals(vo.getSerialNum())) {
					flag = true;
					break;
				}
				index++;
			}

			if (flag) {
				this.toyList.remove(index);
			}
		}

		return flag;
	}

	@Override
	public boolean updateToy(Toy toy) {
		String serialNum = toy.getSerialNum();
		int index = 0;

		for (Toy vo : toyList) {
			if (serialNum.equals(vo.getSerialNum())) {
				break;
			}
		}

		return false;
	}

	@Override
	public List<Toy> toyListForPrice(int minPrice, int maxPrice) {
		List<Toy> searchedList = new ArrayList<>();
		if (toyList != null || toyList.isEmpty()) {
			for (Toy vo : toyList) {
				if (minPrice <= vo.getPrice() && maxPrice >= vo.getPrice()) {
					searchedList.add(vo);
				}
			}
		} else {
			searchedList = null;
		}

		return searchedList;
	}

	@Override
	public List<Toy> groupSearch(int type) {
		List<Toy> group = new ArrayList<>();
		
		if (type == 1) {
			group = this.toyList;
		} else if (type == 2) {
			for (Toy vo : toyList) {
				if (vo instanceof Bicycle) {
					group.add(vo);
				}
			}
		} else if (type == 3) {
			for (Toy vo : toyList) {
				if (vo instanceof Drone) {
					group.add(vo);
				}
			}
		} else if (type == 4) {
			for (Toy vo : toyList) {
				if (vo instanceof GameConsole) {
					group.add(vo);
				}
			}
		} else {
			group = null;
		}
		return group;
	}

}
