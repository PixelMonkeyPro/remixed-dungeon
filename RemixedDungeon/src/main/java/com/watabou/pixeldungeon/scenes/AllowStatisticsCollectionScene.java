package com.watabou.pixeldungeon.scenes;

import com.nyrds.pixeldungeon.game.GameLoop;
import com.nyrds.pixeldungeon.ml.R;
import com.nyrds.platform.storage.Preferences;
import com.nyrds.platform.util.StringsManager;
import com.nyrds.util.GuiProperties;
import com.watabou.noosa.Camera;
import com.watabou.noosa.NinePatch;
import com.watabou.noosa.Text;
import com.watabou.noosa.ui.Component;
import com.watabou.pixeldungeon.Chrome;
import com.watabou.pixeldungeon.ui.Archs;
import com.watabou.pixeldungeon.ui.RedButton;
import com.watabou.pixeldungeon.ui.ScrollPane;

public class AllowStatisticsCollectionScene extends PixelScene {

	private static final int GAP = 4;

	@Override
	public void create() {
		super.create();

        Text title = createMultiline(StringsManager.getVar(R.string.AllowStatisticsCollectionScene_Title), GuiProperties.bigTitleFontSize());

		int w = Camera.main.width;
		int h = Camera.main.height;

		int pw = w - 10;

		title.maxWidth(pw);

		title.x = align((w - title.width()) / 2);
		title.y = align(8);
		add(title);

		NinePatch panel = Chrome.get(Chrome.Type.WINDOW);

		panel.x = (w - pw) / 2;
		panel.y = title.y + title.height() + GAP * 2;
		int ph = (int) (h - panel.y - 22);

		panel.size(pw, ph);

		add(panel);

		ScrollPane list = new ScrollPane(new Component());
		add(list);
		list.setRect(panel.x + panel.marginLeft(), panel.y + panel.marginTop(), panel.innerWidth(),
				panel.innerHeight());
		list.scrollTo(0, 0);

		Component content = list.content();
		content.clear();

		float yPos = 0;
        Text text = createMultiline(StringsManager.getVar(R.string.AllowStatisticsCollectionScene_Request), GuiProperties.regularFontSize());
		text.maxWidth((int) panel.innerWidth());

		content.add(text);
		yPos += text.height() + GAP;

		content.setSize(panel.innerWidth(), yPos);

        RedButton allow = new RedButton(StringsManager.getVar(R.string.AllowStatisticsCollectionScene_Allow)) {
			@Override
			protected void onClick() {
				Preferences.INSTANCE.put(Preferences.KEY_COLLECT_STATS, 100);
				GameLoop.switchScene(TitleScene.class);
			}
		};

        RedButton deny = new RedButton(StringsManager.getVar(R.string.AllowStatisticsCollectionScene_Deny)) {
			@Override
			protected void onClick() {
				Preferences.INSTANCE.put(Preferences.KEY_COLLECT_STATS, -100);
				GameLoop.switchScene(TitleScene.class);
			}
		};

		allow.setRect((w - pw) / 2, h - 22, pw/2 - GAP, 18);
		deny.setRect((w - pw) / 2 + pw/2 , h - 22, pw/2-GAP, 18);
		add(allow);
		add(deny);

		Archs archs = new Archs();
		archs.setSize(Camera.main.width, Camera.main.height);
		addToBack(archs);

		fadeIn();
	}
}
