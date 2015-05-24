package mybiz.inventory.struts.action;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mybiz.inventory.model.ItemIn;
import mybiz.inventory.model.ItemSell;
import mybiz.inventory.service.ItemService;
import mybiz.inventory.struts.form.SellForm;
import mybiz.inventory.struts.form.SellMutipleForm;
import mybiz.inventory.vo.ItemInView;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.springframework.beans.BeanUtils;

public class SellMutipleAction extends Action {
	private static final Logger logger = Logger.getLogger(SellMutipleAction.class);
	
	private ItemService itemService;
	public void setItemService(ItemService itemService) {
		this.itemService = itemService;
	}
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		if (isCancelled(request)) {
			return mapping.findForward("cancel");
		}
		
		logger.info("execute sell mutiple action");
		SellMutipleForm sellMutipleForm = (SellMutipleForm)form;
		
		String[] itemInIdParams = sellMutipleForm.getSellids();
		
		if (itemInIdParams == null || itemInIdParams.length <= 0) {
			logger.info("getSellids::"+sellMutipleForm.getSellids());
		}
		
		for (String idStr:sellMutipleForm.getItemInSellSizesMap().keySet()) {
			logger.info("getItemInSellSizesMap::key::"+idStr);
			logger.info("getItemInSellSizesMap::value::"+sellMutipleForm.getItemInSellSizesMap().get(idStr)[0]);
			logger.info("getItemInSellPricesMap::value::"+sellMutipleForm.getItemInSellPricesMap().get(idStr)[0]);
		}
		
		logger.info("itemidParam::"+itemInIdParams.length);
		for (String idstr : itemInIdParams) {
			logger.info("id::"+idstr);
			Long id = Long.valueOf(idstr);
			ItemIn itemIn = itemService.findItemInById(id).get(0);
			sellMutipleForm.getItemIns().add(itemIn);
			ItemInView itemInView = new ItemInView();
			BeanUtils.copyProperties(itemIn, itemInView);
			sellMutipleForm.getItemInViews().add(itemInView);
			
			Long soldSize = itemService.findAllItemSellTotalSoldSizeByItemInId(itemIn);
			logger.info("soldSize::"+soldSize);
			sellMutipleForm.getItemInSoldSizesMap().put(id, soldSize);
			
			List<ItemSell> soldList = itemService.findAllItemSellByItemIn(itemIn);
			String[] soldsizearr = new String[soldList.size()+1];
			if (sellMutipleForm.getItemInSellSizesMap().get(idstr) != null) {
				soldsizearr[0] = sellMutipleForm.getItemInSellSizesMap().get(idstr)[0];
			}
			for (int i=0;i<soldList.size();i++) {
				ItemSell itemSell = soldList.get(i);
				if (itemSell != null && itemSell.getSellSiez()!=null) {
					soldsizearr[i+1]=String.valueOf(itemSell.getSellSiez());
				}
			}
			sellMutipleForm.getItemInSellSizesMap().put(idstr, soldsizearr);
			String[] soldpricearr = new String[soldList.size()+1];
			if (sellMutipleForm.getItemInSellPricesMap().get(idstr) != null) {
				soldpricearr[0] = sellMutipleForm.getItemInSellPricesMap().get(idstr)[0];
			}
			for (int i=0;i<soldList.size();i++) {
				ItemSell itemSell = soldList.get(i);
				if (itemSell != null && itemSell.getSellPrice()!=null ) {
					soldpricearr[i+1]=String.valueOf(itemSell.getSellPrice().toPlainString());
				}
			}
			sellMutipleForm.getItemInSellPricesMap().put(idstr, soldpricearr);
		}
		
		request.setAttribute("itemInViews", sellMutipleForm.getItemInViews());
		request.setAttribute("itemInSoldSizesMap", sellMutipleForm.getItemInSoldSizesMap());
		request.setAttribute("sellids", itemInIdParams);
		request.setAttribute("itemInSellSizesMap", sellMutipleForm.getItemInSellSizesMap());
		request.setAttribute("itemInSellPricesMap", sellMutipleForm.getItemInSellPricesMap());
		
		saveToken(request);
		return mapping.findForward("sellmutiple");
	}
	
}
