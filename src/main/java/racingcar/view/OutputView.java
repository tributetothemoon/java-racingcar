package racingcar.view;

import racingcar.domain.CarDto;
import racingcar.domain.CarsDto;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * OutputView.java
 * 입력을 제외한 출력을 담당하는 View 클래스
 *
 * @author Kimun Kim, github.com/tributetothemoon
 */
public class OutputView {
    private static final String ERROR_MESSAGE_FORMAT = "[ERROR] %s";
    private static final String POSITION_FORMAT = "%s : %s";
    private static final String WINNERS_LIST = "최종 우승자 : ";
    private static final String EXECUTION_RESULT = "실행 결과";
    private static final char POSITION_CHARACTER = '-';

    private static OutputView instance;

    public static OutputView getInstance() {
        if (instance == null) {
            instance = new OutputView();
        }
        return instance;
    }

    public void printErrorMessage(Exception e) {
        System.out.println(String.format(ERROR_MESSAGE_FORMAT, e.getMessage()));
    }

    public void printResultMessage() {
        System.out.println(EXECUTION_RESULT);
    }

    public void printCarsPosition(CarsDto carsDto) {
        carsDto.toList().forEach(this::printCarPosition);
        System.out.println();
    }

    private void printCarPosition(CarDto carDto) {
        StringBuffer positionStringBuffer = new StringBuffer();
        for (int i = 0; i < carDto.getPosition(); i++) {
            positionStringBuffer.append(POSITION_CHARACTER);
        }
        System.out.print(String.format(POSITION_FORMAT, carDto.getName(), positionStringBuffer));
        System.out.println();   // 개행
    }

    public void printWinners(List<String> winners) {
        Collections.sort(winners);
        System.out.print(WINNERS_LIST);

        Iterator<String> iterator = winners.iterator();
        System.out.print(iterator.next());
        while(iterator.hasNext()) {
            System.out.print(", " + iterator.next());
        }
    }
}
