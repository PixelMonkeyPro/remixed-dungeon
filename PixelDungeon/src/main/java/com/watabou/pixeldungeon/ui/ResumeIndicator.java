package com.watabou.pixeldungeon.ui;

import com.watabou.pixeldungeon.Assets;
import com.watabou.pixeldungeon.Chrome;
import com.watabou.pixeldungeon.Dungeon;
import com.watabou.pixeldungeon.windows.elements.Tool;

public class ResumeIndicator extends Tag {
	
	private Tool btnResume;
	
	public ResumeIndicator() {
		super( 0x00000000);
		
		setSize( 24, 26 );
		
		setVisible(true);
	}
	
	@Override
	protected void createChildren() {
		super.createChildren();
		
		add(btnResume = new Tool(Assets.UI_ICONS, 10, Chrome.Type.ACTION_BUTTON) {
			@Override
			protected void onClick() {
				Dungeon.hero.resume();
			}
		});
	}
	
	@Override
	protected void layout() {
		btnResume.setPos(x-btnResume.width() + width(), y);
		
		super.layout();
	}
	
	
	@Override
	public void update() {
		
		boolean visible = Dungeon.hero.lastAction != null;
		
		btnResume.setVisible(visible);
		setVisible(visible);
		
		super.update();
	}

}
