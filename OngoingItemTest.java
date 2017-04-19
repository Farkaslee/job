//package com.lufax.asset;
//
//import com.lufax.asset.common.BaseJerseyTest;
//import com.lufax.asset.common.HttpRemoteInvoker;
//import com.lufax.asset.common.InterfaceCallObject;
//import com.lufax.asset.domain.enums.AssetItemCategory;
//import com.lufax.asset.domain.enums.AssetItemTypeEnum;
//import com.lufax.jersey.client.JerseyHost;
//import com.lufax.jersey.client.JerseyService;
//import junit.framework.Assert;
//import org.junit.Before;
//import org.junit.Test;
//
///**
// * Created by lifangliang055 on 2016/12/19.
// * 持有中资产接口测试
// */
//public class OngoingItemTest extends BaseJerseyTest {
//
//    private HttpRemoteInvoker httpRemoteInvoker;
//
//    @Before
//    public void init(){
//        httpRemoteInvoker=new HttpRemoteInvoker();
//        JerseyService jerseyService=new JerseyService();
//        JerseyHost host=new JerseyHost();
//        host.setHostURI("http://localhost:9998/");
//        jerseyService.setHost(host);
//        httpRemoteInvoker.setJerseyService(jerseyService);
//    }
//
//    @Test
//    public void testOngoingINvestmentAll(){
//        testOngoingInvestmentAllV3_1();//P2P
//        testOngoingInvestmentAllV3_2();//B2C
//        testOngoingInvestmentAllV3_3();//理财型保险
//        testOngoingInvestmentAllV3_4();//公募基金
//        testOngoingInvestmentAllV3_5();//活期
//        testOngoingInvestmentAllV3_6();//高端理财---券商
//    }
//
//
//    /**
//     *
//     * 持有中资产V3 接口 涵盖P2P 资产
//     * 901 902 903 905 906 907 908 910 501 B01 /201 301 401
//     */
//    public void testOngoingInvestmentAllV3_1(){
//        InterfaceCallObject interfaceCallObject = new InterfaceCallObject();
//        interfaceCallObject.addUrl("/v3/investments/investment-all-v3");
//        interfaceCallObject.addQueryParam("assetType", AssetItemCategory.PEER2PEER.name());
//        interfaceCallObject.addUserId(1751940L);
//        String result = httpRemoteInvoker.get(interfaceCallObject);
//        Assert.assertTrue(result.indexOf("\"res_code\":\"251000\"")>=0);
//        interfaceCallObject.addUrl("/v3/investments/investment-all-v3");
//        interfaceCallObject.addQueryParam("assetType", AssetItemTypeEnum.FINANCE.name());
//        interfaceCallObject.addUserId(1118694L);
//        String result1 = httpRemoteInvoker.get(interfaceCallObject);
//        Assert.assertTrue(result1.indexOf("\"res_code\":\"251000\"")>=0);
//    }
//
//
//    /**
//     *涵盖定期资产
//     * 持有中资产V3 接口
//     * 601 301 401 203 204 /902 501 908
//     *
//     */
//    public void testOngoingInvestmentAllV3_2(){
//        InterfaceCallObject interfaceCallObject = new InterfaceCallObject();
//        interfaceCallObject.addUrl("/v3/investments/investment-all-v3");
//        interfaceCallObject.addQueryParam("assetType", AssetItemCategory.REGULAR.name());
//        interfaceCallObject.addUserId(584813L);
//        String result = httpRemoteInvoker.get(interfaceCallObject);
//        Assert.assertTrue(result.indexOf("\"res_code\":\"251000\"")>=0);
//    }
//
//
//    /**
//     * 理财型保险
//     * 持有中资产V3 接口
//     * 605
//     *
//     */
//    public void testOngoingInvestmentAllV3_3(){
//        InterfaceCallObject interfaceCallObject = new InterfaceCallObject();
//        interfaceCallObject.addUrl("/v3/investments/investment-all-v3");
//        interfaceCallObject.addQueryParam("assetType", AssetItemCategory.REGULAR.name());
//        interfaceCallObject.addUserId(2066649L);
//        String result = httpRemoteInvoker.get(interfaceCallObject);
//        Assert.assertTrue(result.indexOf("\"res_code\":\"251000\"")>=0);
//    }
//
//    /**
//     * 公募基金
//     * 持有中资产V3 接口，------570776L
//     * 802
//     *
//     */
//    public void testOngoingInvestmentAllV3_4(){
//        InterfaceCallObject interfaceCallObject = new InterfaceCallObject();
//        interfaceCallObject.addUrl("/v3/investments/investment-all-v3");
//        interfaceCallObject.addQueryParam("assetType", AssetItemTypeEnum.FUND.name());
//        interfaceCallObject.addUserId(614007L);
//        String result = httpRemoteInvoker.get(interfaceCallObject);
//        Assert.assertTrue(result.indexOf("\"res_code\":\"251000\"")>=0);
//    }
//
//    /**
//     * 活期
//     * 持有中资产V3 接口，------570776L
//     * 801 零活宝 803 富盈宝宝
//     * F01  806---- 超级类货基 2036960
//     *
//     */
//
//    public void testOngoingInvestmentAllV3_5(){
//        InterfaceCallObject interfaceCallObject = new InterfaceCallObject();
//        interfaceCallObject.addUrl("/v3/investments/investment-all-v3");
//        interfaceCallObject.addQueryParam("assetType", AssetItemCategory.DEMAND.name());
//        interfaceCallObject.addUserId(570776L);
//        String result = httpRemoteInvoker.get(interfaceCallObject);
//        Assert.assertTrue(result.indexOf("\"res_code\":\"251000\"")>=0);
//
//        InterfaceCallObject interfaceCallObject1 = new InterfaceCallObject();
//        interfaceCallObject1.addUrl("/v3/investments/investment-all-v3");
//        interfaceCallObject1.addQueryParam("assetType", AssetItemCategory.DEMAND.name());
//        interfaceCallObject1.addUserId(2036960L);
//        String result1 = httpRemoteInvoker.get(interfaceCallObject1);
//        Assert.assertTrue(result1.indexOf("\"res_code\":\"251000\"")>=0);
//    }
//
//    /**
//     * 高端理财
//     * 持有中资产V3 接口，
//     * G04 -- BROKER
//     *
//     *
//     */
//    public void testOngoingInvestmentAllV3_6(){
//        InterfaceCallObject interfaceCallObject = new InterfaceCallObject();
//        interfaceCallObject.addUrl("/v3/investments/investment-all-v3");
//        interfaceCallObject.addQueryParam("assetType", AssetItemCategory.HIGH_END.name());
//        interfaceCallObject.addUserId(1837560L);
//        String result = httpRemoteInvoker.get(interfaceCallObject);
//        Assert.assertTrue(result.indexOf("\"res_code\":\"251000\"")>=0);
//    }
//
//    /**
//     * 高端理财
//     * 持有中资产V3 接口，
//     * 信托A02和私募C01
//     *
//     *
//     */
//    @Test
//    public void testOngoingInvestmentAllV3_7(){
//        InterfaceCallObject interfaceCallObject = new InterfaceCallObject();
//        interfaceCallObject.addUrl("/v3/investments/investment-all-v3");
//        interfaceCallObject.addQueryParam("assetType", AssetItemCategory.HIGH_END.name());
//        interfaceCallObject.addUserId(589626L);
//        String result = httpRemoteInvoker.get(interfaceCallObject);
//        Assert.assertTrue(result.indexOf("\"res_code\":\"251000\"")>=0);
//    }
//
//
//}
