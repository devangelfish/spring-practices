package container.config.videosystem;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import container.videosystem.Avengers;
import container.videosystem.DVDPlayer;
import container.videosystem.DigitalVideoDisc;

@Configuration
public class DVDPlayerConfig {
	
	@Bean
	public Avengers avengers() {
		return new Avengers();
	}
	
	// 주입하기01 : 파라미터로 Bean 전달하기 : setter 주입
	// @Bean
	public DVDPlayer dvdplayer01(DigitalVideoDisc dvd) {
		DVDPlayer dvdPlayer = new DVDPlayer();
		dvdPlayer.setDvd(dvd);
		return dvdPlayer;
	}
	
	// 주입하기02 : 생성자 주입 : 파라미터로 Bean 전달하기
	// @Bean
	public DVDPlayer dvdPlayer02(DigitalVideoDisc dvd) {
		return new DVDPlayer(dvd);
	}
	
	// 주입하기03 : 생성자 주입 : Bean 생성 메소드를 직접 호출 (잘 쓰지 않음)
	@Bean
	public DVDPlayer dvdPlayer03() {
		return new DVDPlayer(avengers());
	}
	
	// 주입하기04 : 같은 타입을 생성할 경우
	@Bean("player04")
	public DVDPlayer dvdPlayer04() {
		return new DVDPlayer(avengers());
	}
}
