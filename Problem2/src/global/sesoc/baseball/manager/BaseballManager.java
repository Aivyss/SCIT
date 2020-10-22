package global.sesoc.baseball.manager;

import java.util.ArrayList;
import java.util.List;

import global.sesoc.baseball.vo.Batter;
import global.sesoc.baseball.vo.Pitcher;
import global.sesoc.baseball.vo.Player;

/**
 * 데이터의 처리를 담당
 */
public class BaseballManager implements AbstractBaseballManager {
	/**
	 * 선수 정보를 저장할 리스트
	 */
	private List<Player> playerList;

	/**
	 * 생성자
	 */
	public BaseballManager() {
		// 기존 저장된 파일이 있으면 열어서 읽는다.
		// 저장된 파일이 없으면 새로운 리스트를 생성한다.
		this.playerList = new ArrayList<>();
	}
	/**
	 * 선수 전체 리스트의 사이즈가 0인 경우 리턴값은 null이 된다. 선수리스트의 사이즈가 0이 아닌 경우
	 * id와 일치하는 선수를 탐색한다 (for 문). if문을 통해 결과가 있으면 vo에 그 객체를 넣어준다.
	 * 일치하는 선수(객체)가 없으면 리턴값은 아무것도 넣지 않았으므로 마찬가지로 null이다.
	 * 
	 * @return Player 객체
	 */
	@Override
	public Player searchId(String id) {
		Player vo = null;

		if (!playerList.isEmpty()) { // 선수의 전체 리스트의 사이즈가 0이 아닌 경우
			for (Player search : playerList) {
				if (id.equals(search.getId())) {
					vo = search;
					break;
				}
			}
		} 
		
		return vo;
	}
	/**
	 * 플레이어 객체를 list에 넣어주는 기능을 수행한다.
	 * @return boolean -> 추가되지 못하면 false 추가되면 true를 반환 *
	 */
	@Override
	public boolean insertPlayer(Player player) {
		boolean flag = false;

		if (this.searchId(player.getId()) != null) {
			flag = false; // 중복값이 있는 경우로 추가 하면 안됨.
		} else {
			playerList.add(player);
			flag = true; // 추가 됨
		}

		return flag;
	}
	/**
	 * id에 일치하는 선수를 list에서 삭제하는 기능을 수행한다.
	 * @return boolean 삭제에 성공하면 true 실패하면 false를 반환.
	 */
	@Override
	public boolean deletePlayer(String id) {
		Player vo = this.searchId(id);
		boolean flag = false; // 삭제되지 않음을 의미.

		if (vo != null) {
			int index = 0;
			for (Player search : playerList) {
				if (id.equals(search.getId())) {
					flag = true;
					break;
				}
				index++;
			}
			this.playerList.remove(index);
		}

		return flag;
	}
	
	/**
	 * id가 일치하는 플레이어의 연봉을 수정하는 기능을 수행하는 메소드
	 * @return boolean 플레이어를 찾을 수 없을 경우 false, 찾아내어 수정에 성공하면 true.
	 */
	@Override
	public boolean updatePlayer(Player player) {
		boolean flag = false;

		String targetName = player.getName();
		int index = 0;
		if (!this.playerList.isEmpty()) {
			flag = true;
			for (Player vo : playerList) {
				if (targetName.equals(vo.getName())) {
					break;
				}
				index++;
			}
		}

		this.playerList.set(index, player);

		return flag;
	}
	/**
	 * 해당 연봉 범위에 있는 플레이어들의 리스트를 만들어 반환하는 기능을 수행하는 메소드.
	 * @return List<Player> 객체, 연봄 범위 안에 있는 모든 선수가 담겨 있다.
	 */
	@Override
	public List<Player> playerListForSalary(int minSalary, int maxSalary) {
		List<Player> result = new ArrayList<>();

		if (!playerList.isEmpty()) {
			for (Player vo : playerList) {
				if (minSalary <= vo.getSalary() && maxSalary >= vo.getSalary()) {
					result.add(vo);
				}
			}
		} else {
			result = null;
		}
		return result;
	}
	/**
	 * 각 포지션별로 War가 가장 높은 선수들을 list에 담아서 반환하는 기능을 수행하는 메소드.
	 * @return List<Player> 각 포지션 별 베스트 플레이어들이 담겨 있는 list객체
	 */
	@Override
	public List<Player> bestPlayers() {
		double[] maxWar = new double[2];
		List<Player> listPitcher = this.playerListForType(2);
		List<Player> listBatter = this.playerListForType(3);
		List<Player> result = new ArrayList<>();
		
		if (!playerList.isEmpty()) {
			for (Player vo : listPitcher) {
				if (maxWar[0] < vo.getWar()) {
					maxWar[0] = vo.getWar();
				}
			}
			
			for (Player vo : listBatter) {
				if (maxWar[1] < vo.getWar()) {
					maxWar[1] = vo.getWar();
				}
			}

			for (Player vo : listPitcher) {
				if (vo.getWar() == maxWar[0]) {
					result.add(vo);
				}
			}
			
			for (Player vo : listBatter) {
				if (vo.getWar() == maxWar[1]) {
					result.add(vo);
				}
			}
			
		} else {
			result = null;
		}

		return result;
	}
	
	/**
	 * 포지션을 선택하면 그 포지션에 해당하는 선수의 리스트를 반환하는 기능을 수행하는 메소드
	 * @param type --> 1인 경우 전체리스트 2인 경우 Pitcher 리스트 3인 경우 batter 리스트를 의미함
	 * @return List<Player> 포지션에 해당하는 선수들이 담긴 list 객체 
	 */
	@Override
	public List<Player> playerListForType(int type) {
		List<Player> list = new ArrayList<>();

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
	 * 선수 전체가 담긴 리스트를 반환하는 기능을 수행
	 * @return ArrayList<Player> 선수 전체가 담긴 리스트
	 */
	public List<Player> getPlayerList() {
		return playerList;
	}
}