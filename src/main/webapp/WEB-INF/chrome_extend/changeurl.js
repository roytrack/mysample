/**
 * Created by Administrator on 2015/1/10.
 */

var articleData = {};
function checkForValidUrl(tabId, changeInfo, tab) {
    var abc=tab.url;
    if(abc.indexOf("index")>-1){
        abc=abc.replace("index","icPay");
        //alert("new url:"+abc);
        articleData.url=abc;
        chrome.pageAction.show(tabId);
        var updateProperties={url:abc}
        chrome.tabs.update(tabId,  updateProperties)
    }
};


chrome.tabs.onUpdated.addListener(checkForValidUrl);
//chrome.pageAction.onClicked.addListener(jump)