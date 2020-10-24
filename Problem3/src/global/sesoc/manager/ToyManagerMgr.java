package global.sesoc.manager;

import java.util.ArrayList;
import java.util.List;

import global.sesoc.vo.Bicycle;
import global.sesoc.vo.Drone;
import global.sesoc.vo.GameConsole;
import global.sesoc.vo.Toy;

public class ToyManagerMgr implements ToyManager {
	/**
	 * 장난감 객체가 들어가는 리스트.
	 */
	private List<Toy> toyList;

	/**
	 * Constructor
	 */
	public ToyManagerMgr() {
		this.toyList = new ArrayList<>();
	}

	@Override
	public Toy searchToy(String serialNum) {
		Toy toy = null;

		if (ValidationChecker.listValidation(toyList)) {
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

		if (!ValidationChecker.voValidation(toy)) {
			flag = false;
		} else {
			if (ValidationChecker.listValidation(toyList)) {
				Toy searched = this.searchToy(toy.getSerialNum());

				if (ValidationChecker.voValidation(searched)) {
					flag = false;
				}
			}
		}

		if (flag) {
			this.toyList.add(toy);
		}

		return flag; // true --> success
	}

	@Override
	public boolean deleteToy(String serialNum) {
		boolean flag = false;

		if (ValidationChecker.listValidation(toyList)) {
			Toy searched = this.searchToy(serialNum);
			if (ValidationChecker.voValidation(searched)) {
				flag = true;
				this.toyList.remove(searched);
			}
		}

		return flag;
	}

	@Override
	public boolean updateToy(Toy toy) {
		boolean flag = false;

		String serialNum = toy.getSerialNum();
		if (ValidationChecker.voValidation(toy) && ValidationChecker.listValidation(toyList)) {
			int index = 0;

			// search Index
			for (Toy vo : toyList) {
				if (serialNum.equals(vo)) {
					flag = true;
					this.toyList.set(index, toy);
					break;
				}
				index++;
			}
		}

		return flag;
	}

	@Override
	public List<Toy> toyListForPrice(int minPrice, int maxPrice) {
		List<Toy> searchedList = new ArrayList<>();

		if (ValidationChecker.listValidation(toyList)) {
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