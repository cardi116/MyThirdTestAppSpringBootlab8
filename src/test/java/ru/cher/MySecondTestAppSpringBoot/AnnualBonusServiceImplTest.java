package ru.cher.MySecondTestAppSpringBoot;
import ru.cher.MySecondTestAppSpringBoot.service.AnnualBonusServiceImpl;

import org.junit.jupiter.api.Test;
import ru.cher.MySecondTestAppSpringBoot.model.Positions;

import java.time.Year;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class AnnualBonusServiceImplTest {

    private final AnnualBonusServiceImpl annualBonusService = new AnnualBonusServiceImpl();

    @Test
    void calculateAnnualBonusTest() {
        // given
        Positions position = Positions.HR;
        double bonus = 2.0;
        int workDays = 243;
        double salary = 100000.00;
        int daysInYear = Year.now().isLeap() ? 366 : 365;

        // when
        double result = annualBonusService.calculate(position, salary, bonus, workDays);

        // then
        double expected = salary * bonus * daysInYear * position.getPositionCoefficient() / workDays;
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void calculateQuarterlyBonusForManagerTest() {
        // given
        Positions position = Positions.TL; // isManager == true
        double bonus = 1.5;
        double salary = 150000.00;

        // when
        double result = annualBonusService.calculateQuarterlyBonus(position, salary, bonus);

        // then
        double expected = salary * bonus * 3 * position.getPositionCoefficient();
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void calculateQuarterlyBonusForNonManagerShouldThrowExceptionTest() {
        // given
        Positions position = Positions.DEV; // isManager == false
        double bonus = 1.0;
        double salary = 100000.00;

        // when & then
        assertThatThrownBy(() -> annualBonusService.calculateQuarterlyBonus(position, salary, bonus))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Сотрудник не является управленцем (isManager == false)");
    }
}