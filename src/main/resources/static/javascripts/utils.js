var Utils = Utils || {};

numeral.language('pt-br');
moment.locale('pt-br');

Utils.MaskMoney = (function() {
	
	function MaskMoney() {
		this.decimal = $('.js-decimal');
		this.plain = $('.js-plain');
	}
	
	MaskMoney.prototype.enable = function() {
		this.decimal.maskMoney({ decimal: ',', thousands: '.' });
		this.plain.maskMoney({ precision: 0, thousands: '.' });
	}
	
	return MaskMoney;
	
}());

Utils.Security = (function() {
	
	function Security() {
		this.token = $('input[name=_csrf]').val();
		this.header = $('input[name=_csrf_header]').val();
	}
	
	Security.prototype.enable = function() {
		$(document).ajaxSend(function(event, jqxhr, settings) {
			jqxhr.setRequestHeader(this.header, this.token);
		}.bind(this));
	}
	
	return Security;
	
}());

Utils.SideMenuLevel = (function() {
	
	function initSideMenu() {
		this.menuItem = $('.treeview-submenu-item.active');
	}
	
	initSideMenu.prototype.enable = function() {
		this.menuItem.parents('.treeview-submenu-level-2').addClass('active');
		this.menuItem.parents('.treeview').addClass('active');
	}
	
	return initSideMenu;
	
}());


$(function() {
	var maskMoney = new Utils.MaskMoney();
	maskMoney.enable();
	
	var security = new Utils.Security();
	security.enable();
	
	var sideMenuLevel = new Utils.SideMenuLevel();
	sideMenuLevel.enable();
});