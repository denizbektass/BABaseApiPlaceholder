package com.bilgeadam.BABaseApiPlaceholder.utility;

import com.bilgeadam.BABaseApiPlaceholder.repository.entity.Trainer;
import com.bilgeadam.BABaseApiPlaceholder.repository.enums.ETrainerRole;
import com.bilgeadam.BABaseApiPlaceholder.service.TrainerService;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TestAndRun {

    public final TrainerService trainerService;

    @PostConstruct
    public void defaultTrainerData() {
        trainerService.save(Trainer.builder().email("trainer.selim.peon@gmail.com").name("Selim").surname("Gülnihal").trainerRole(ETrainerRole.MASTER_TRAINER).build());
        trainerService.save(Trainer.builder().email("trainer.aktasberk96@gmail.com").name("Berk").surname("Aktaş").trainerRole(ETrainerRole.MASTER_TRAINER).build());
        trainerService.save(Trainer.builder().email("trainer.doruk.tokinan@gmail.com").name("Doruk").surname("Tokinan").trainerRole(ETrainerRole.ASSISTANT_TRAINER).build());
    }

}
