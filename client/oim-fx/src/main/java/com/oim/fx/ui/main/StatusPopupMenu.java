package com.oim.fx.ui.main;

import com.oim.fx.common.box.ImageBox;
import com.only.fx.common.action.ExecuteAction;
import com.only.fx.common.component.OnlyContextMenu;
import com.only.fx.common.component.OnlyMenuItem;
import com.onlyxiahui.im.bean.UserData;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * @author: XiaHui
 * @date: 2016年10月11日 下午3:43:16
 */
public class StatusPopupMenu extends OnlyContextMenu {

	private OnlyMenuItem awayMenuItem = new OnlyMenuItem();
	private OnlyMenuItem busyMenuItem = new OnlyMenuItem();
	private OnlyMenuItem invisibleMenuItem = new OnlyMenuItem();

	private SeparatorMenuItem separator1 = new SeparatorMenuItem();
	private SeparatorMenuItem separator2 = new SeparatorMenuItem();
	private SeparatorMenuItem separator3 = new SeparatorMenuItem();
	private OnlyMenuItem muteMenuItem = new OnlyMenuItem();
	private OnlyMenuItem omeMenuItem = new OnlyMenuItem();
	private OnlyMenuItem onlineMenuItem = new OnlyMenuItem();
	private OnlyMenuItem offlineMenuItem = new OnlyMenuItem();

	Image onlineImage = ImageBox.getImageClassPath("/common/images/status/flag/big/imonline.png");
	Image callMeImage = ImageBox.getImageClassPath("/common/images/status/flag/big/call_me.png");
	Image awayImage = ImageBox.getImageClassPath("/common/images/status/flag/big/away.png");
	Image busyImage = ImageBox.getImageClassPath("/common/images/status/flag/big/busy.png");
	Image muteImage = ImageBox.getImageClassPath("/common/images/status/flag/big/mute.png");
	Image invisibleImage = ImageBox.getImageClassPath("/common/images/status/flag/big/invisible.png");
	Image offlineImage = ImageBox.getImageClassPath("/common/images/status/flag/big/imoffline.png");

	ImageView onlineImageView = new ImageView();
	ImageView callMeImageView = new ImageView();
	ImageView awayImageView = new ImageView();
	ImageView busyImageView = new ImageView();
	ImageView muteImageView = new ImageView();
	ImageView invisibleImageView = new ImageView();
	ImageView offlineImageView = new ImageView();

	private ExecuteAction statusAction;

	public StatusPopupMenu() {
		initMenu();
	}

	private void initMenu() {

		onlineImageView.setImage(onlineImage);
		callMeImageView.setImage(callMeImage);
		awayImageView.setImage(awayImage);
		busyImageView.setImage(busyImage);
		muteImageView.setImage(muteImage);
		invisibleImageView.setImage(invisibleImage);
		offlineImageView.setImage(offlineImage);

		onlineMenuItem.setText("我在线上");
		omeMenuItem.setText("Call我吧");
		awayMenuItem.setText("离开");
		busyMenuItem.setText("忙碌");
		muteMenuItem.setText("请勿打扰");
		invisibleMenuItem.setText("隐身");
		offlineMenuItem.setText("离线");

		onlineMenuItem.setGraphic(onlineImageView);
		omeMenuItem.setGraphic(callMeImageView);
		awayMenuItem.setGraphic(awayImageView);
		busyMenuItem.setGraphic(busyImageView);
		muteMenuItem.setGraphic(muteImageView);
		invisibleMenuItem.setGraphic(invisibleImageView);
		offlineMenuItem.setGraphic(offlineImageView);

		this.getItems().add(onlineMenuItem);
		this.getItems().add(omeMenuItem);
		this.getItems().add(separator1);
		this.getItems().add(awayMenuItem);
		this.getItems().add(busyMenuItem);
		this.getItems().add(muteMenuItem);
		this.getItems().add(separator2);
		this.getItems().add(invisibleMenuItem);
		this.getItems().add(separator3);
		this.getItems().add(offlineMenuItem);

		onlineMenuItem.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				onlineMenuItemActionPerformed();
			}
		});
		omeMenuItem.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				omeMenuItemActionPerformed();
			}
		});
		awayMenuItem.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				awayMenuItemActionPerformed();
			}
		});
		busyMenuItem.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				busyMenuItemActionPerformed();
			}
		});
		muteMenuItem.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				muteMenuItemActionPerformed();
			}
		});
		invisibleMenuItem.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				invisibleMenuItemActionPerformed();
			}
		});
		offlineMenuItem.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				offlineMenuItemActionPerformed();
			}
		});

	}

	private void onlineMenuItemActionPerformed() {
		updateStatus(UserData.status_online);
	}

	private void omeMenuItemActionPerformed() {
		updateStatus(UserData.status_call_me);
	}

	private void awayMenuItemActionPerformed() {
		updateStatus(UserData.status_away);
	}

	private void busyMenuItemActionPerformed() {
		updateStatus(UserData.status_busy);
	}

	private void muteMenuItemActionPerformed() {
		updateStatus(UserData.status_mute);
	}

	private void invisibleMenuItemActionPerformed() {
		updateStatus(UserData.status_invisible);
	}

	private void offlineMenuItemActionPerformed() {
		updateStatus(UserData.status_offline);
	}

	private void updateStatus(String status) {
		if (null != statusAction) {
			statusAction.execute(status);
		}
	}

	public void setStatusAction(ExecuteAction statusAction) {
		this.statusAction = statusAction;
	}
}
