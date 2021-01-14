package container.soundsystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class CDPlayer {
	
	// Wriring01 : 필드 직접주입(CGLib) 
	// @Inject //(자바 표준 Wiring Annotation)
	@Autowired
	@Qualifier("highSchoolRapper3Final")
	private CompactDisc cd;
	
	public CDPlayer() {
	}
	
	// Wriring02 : 생성자 주입
	// @Autowired
	public CDPlayer(@Qualifier("highSchoolRapper3Final") CompactDisc cd) {
		this.cd = cd;
	}
	
	// Wiring02 : setter 주입
	// @Autowired
	public void setCD(@Qualifier("highSchoolRapper3Final")CompactDisc cd) {
		this.cd = cd;
	}
	
	public void play() {
		cd.play();
	}
}
