package global.sesoc.baseball.manager;

import java.util.ArrayList;

import global.sesoc.baseball.vo.Batter;
import global.sesoc.baseball.vo.Pitcher;
import global.sesoc.baseball.vo.Player;

/**
 * 데이터의 처리를 담당
 */
public class BaseballManager implements AbstractBaseballManager{
	/**
	 * 선수 정보를 저장할 리스트
	 */
	private ArrayList<Player> playerList;
	
	/**
	 * 생성자
	 */
	public BaseballManager () {
		//기존 저장된 파일이 있으면 열어서 읽는다.
		//저장된 파일이 없으면 새로운 리스트를 생성한다.
		this.playerList = new ArrayList<>();
	}

	@Override
	public Player searchId(String id) {
		Player vo = null;
		
		if (!playerList.isEmpty()) {
			for (Player search : playerList) {
				if (id.equals(search.getId())) {
					vo = search;
					break;
				}
			}
		} else {
			vo = null;
		}
		
		return vo;
	}

	@Override
	public boolean insertPlayer(Player player) {
		boolean flag = false;

		if (this.searchId(player.getId())!=null) {
			flag = false; // 중복값이 있는 경우로 추가 하면 안됨.
		} else {
			playerList.add(player);
			flag = true; // 추가 됨
		}
		
		return flag;
	}

	@Override
	public boolean deletePlayer(String id) {
		Player vo = this.searchId(id);
		boolean flag = false; // 삭제되지 않음을 의미.
		
		if (vo != null) {
			int index = 0;
			for (Player search : playerList) {
				if(id.equals(search.getId())) {
					flag = true;
					break;
				}
			}			
			this.playerList.remove(index);
		}
		
		return flag;
	}

	@Override
	public boolean updatePlayer(Player player) {
		boolean flag = false;
		
		String targetName = player.getName();
		int index = 0;
		if (!this.playerList.isEmpty()) {
			flag = true;
			for (Player vo : playerList) {
				if(targetName.equals(vo.getName())) {
					break;
				}
				index++;
			}
		}
		
		this.playerList.set(index, player);
		
		return flag;
	}

	@Override
	public ArrayList<Player> playerListForSalary(int minSalary, int maxSalary) {
		ArrayList<Player> result = new ArrayList<>();
		
		if (!playerList.isEmpty()) {
			for (Player vo : playerList) {
				if (minSalary<=vo.getSalary() && maxSalary>=vo.getSalary()) {
					result.add(vo);
				}
			}
		} else {
			result = null;
		}
		return result;
	}

	@Override
	public ArrayList<Player> bestPlayers() {
		double maxWar = 0;
		ArrayList<Player> result = new ArrayList<>();
		
		if (!playerList.isEmpty()) {
			for (Player vo : playerList) {
				if (maxWar < vo.getWar()) {
					maxWar = vo.getWar();
				}
			}
			
			for (Player vo : playerList) {
				if (vo.getWar() == maxWar) {
					result.add(vo);
				}
			}
		} else {
			result = null;
		}
		
		return result;
	}

	@Override
	public ArrayList<Player> playerListForType(int type) {
		ArrayList<Player> list = new ArrayList<>();
		
		if (!playerList.isEmpty()) {
			if (type == 1) {
				list = this.playerList;
			} else if (type == 2) {
				for (Player vo : playerList) {
					if (vo instanceof Pitcher) {
						list.add(vo);
					}
				}
			} else if (type == 3) {
				for (Player vo : playerList) {
					if (vo instanceof Batter) {
						list.add(vo);
					}
				}
			}
		} else {
			list = null;
		}
		
		return list;
	}
	
	/**
	 * Getter
	 * @return ArrayList<Player>
	 */
	public ArrayList<Player> getPlayerList() {
		return playerList;
	}
}


