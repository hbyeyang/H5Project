package com.lt.h5project.bean;

import android.support.annotation.NonNull;

import java.io.Serializable;
import java.util.List;

/**
 * @author yeyang
 * @name H5project
 * @class name：com.lt.h5project.bean
 * @class describe
 * @time 2019-07-24 16:17
 * @change
 * @chang time
 * @class describe
 */
public class NetUrlBean implements Serializable {


    /**
     * ret : succ
     * data : [{"url":"huitoutiao.pipeline.letupower.cn","type":1},{"url":"taoxinwen.pipeline.letupower.cn","type":1},{"url":"taoxinwenv2.pipeline.letupower.cn","type":1},{"url":"niuniutoutiao.pipeline.letupower.cn","type":1},{"url":"zhongqadc.mchannel.pipeline.letupower.cn","type":1},{"url":"xinadc.mchannel.pipeline.letupower.cn","type":1},{"url":"baixadc.mchannel.pipeline.letupower.cn","type":1},{"url":"zhongyadc.mchannel.pipeline.letupower.cn","type":1},{"url":"91adc.mchannel.pipeline.letupower.cn","type":1},{"url":"ltxs1.mchannel.pipeline.letupower.cn","type":1},{"url":"ltxs2.mchannel.pipeline.letupower.cn","type":1},{"url":"ltxs3.mchannel.pipeline.letupower.cn","type":1},{"url":"ltxs4.mchannel.pipeline.letupower.cn","type":1},{"url":"ltxs5.mchannel.pipeline.letupower.cn","type":1},{"url":"ltxs6.mchannel.pipeline.letupower.cn","type":1},{"url":"ltxs7.mchannel.pipeline.letupower.cn","type":1},{"url":"ltxs8.mchannel.pipeline.letupower.cn","type":1},{"url":"ltxs9.mchannel.pipeline.letupower.cn","type":1},{"url":"ltxs10.mchannel.pipeline.letupower.cn","type":1},{"url":"ltxs11.mchannel.pipeline.letupower.cn","type":1},{"url":"ltxs20.mchannel.pipeline.letupower.cn","type":1},{"url":"ltxs12.mchannel.pipeline.letupower.cn","type":1},{"url":"ltxs13.mchannel.pipeline.letupower.cn","type":1},{"url":"ltxs14.mchannel.pipeline.letupower.cn","type":1},{"url":"ltxs15.mchannel.pipeline.letupower.cn","type":1},{"url":"t.channel.45xie.com/api/api?action=showpage&page=index&_pos=home&appid=A09EDF65B8AA7371A99C8C14937B299A","type":2},{"url":"t.channel.45xie.com/api/api?action=showpage&page=index&appid=A0E65217F194E9FEBFBD0FECAC1BB6D9","type":2},{"url":"center.pipeline.letupower.cn","type":1},{"url":"ltxs21.mchannel.pipeline.letupower.cn","type":1},{"url":"ltxs22.mchannel.pipeline.letupower.cn","type":1},{"url":"ltxs23.mchannel.pipeline.letupower.cn","type":1},{"url":"ltxs24.mchannel.pipeline.letupower.cn","type":1},{"url":"ltxs25.mchannel.pipeline.letupower.cn","type":1},{"url":"ltxs26.mchannel.pipeline.letupower.cn","type":1},{"url":"ltxs27.mchannel.pipeline.letupower.cn","type":1},{"url":"ltxs28.mchannel.pipeline.letupower.cn","type":1},{"url":"ltxs29.mchannel.pipeline.letupower.cn","type":1},{"url":"ltxs30.mchannel.pipeline.letupower.cn","type":1},{"url":"ltxs31.mchannel.pipeline.letupower.cn","type":1},{"url":"ltxs32.mchannel.pipeline.letupower.cn","type":1},{"url":"ltxs33.mchannel.pipeline.letupower.cn","type":1},{"url":"ltxs33.mchannel.pipeline.letupower.cn","type":1},{"url":"ltxs34.mchannel.pipeline.letupower.cn","type":1},{"url":"ltxs35.mchannel.pipeline.letupower.cn","type":1},{"url":"ltxs36.mchannel.pipeline.letupower.cn","type":1},{"url":"ltxs37.mchannel.pipeline.letupower.cn","type":1},{"url":"ltxs38.mchannel.pipeline.letupower.cn","type":1},{"url":"ltxs39.mchannel.pipeline.letupower.cn","type":1},{"url":"ltxs40.mchannel.pipeline.letupower.cn","type":1},{"url":"ltxs41.mchannel.pipeline.letupower.cn","type":1},{"url":"ltxs42.mchannel.pipeline.letupower.cn","type":1},{"url":"ltxs43.mchannel.pipeline.letupower.cn","type":1},{"url":"ltxs44.mchannel.pipeline.letupower.cn","type":1},{"url":"ltxs45.mchannel.pipeline.letupower.cn","type":1},{"url":"ltxs46.mchannel.pipeline.letupower.cn","type":1},{"url":"ltxs47.mchannel.pipeline.letupower.cn","type":1},{"url":"ltxs48.mchannel.pipeline.letupower.cn","type":1},{"url":"ltxs49.mchannel.pipeline.letupower.cn","type":1},{"url":"t.channel.45xie.com/api/api?action=showpage&page=picturelist&id=10004&appid=DC441D3E571E42D4CA55EAF9058C04C2&guest=s","type":3},{"url":"t.channel.45xie.com/api/api?action=showpage&page=picturelist&id=10004&appid=54FB38AAFED71B466106A231D833120C&guest=s","type":3},{"url":"t.channel.45xie.com/api/api?action=showpage&page=picturelist&_pos=home&appid=FE8B7C7E899F9B6FF6244B475EF21874&guest=s","type":3},{"url":"t.channel.45xie.com/api/api?action=showpage&page=picturelist&appid=6B82AC7A7A1A30184C2A9D15050A44E6&guest=s","type":3},{"url":"t.channel.45xie.com/api/api?action=showpage&page=picturelist&appid=A79D0C057DE4347F239115823B951D4F&guest=s","type":3},{"url":"t.channel.45xie.com/api/api?action=showpage&page=picturelist&appid=557CA8831EDEB0AB75865A5B40732893&guest=s","type":3},{"url":"t.channel.45xie.com/api/api?action=showpage&page=picturelist&appid=A2D5F19DABC7FE595001A35D711A87E7&guest=s","type":3},{"url":"t.channel.45xie.com/api/api?action=showpage&page=picturelist&appid=1C644DD589C3C80BE9F2A115CE254B09&guest=s","type":3},{"url":"t.channel.45xie.com/api/api?action=showpage&page=picturelist&appid=90B379CBC4C1E7335DDEDD4238308656&guest=s","type":3},{"url":"t.channel.45xie.com/api/api?action=showpage&page=picturelist&appid=08EF28D9D875E8E9E393F97EC1D5E8AA&guest=s","type":3},{"url":"t.channel.45xie.com/api/api?action=showpage&page=picturelist&appid=DF161B97A21A8D1BD80033F4921AC6B9&guest=s","type":3},{"url":"t.channel.45xie.com/api/api?action=showpage&page=picturelist&appid=DDA5A88201FE70CBC98DF7AEEBE398BF&guest=s","type":3},{"url":"t.channel.45xie.com/api/api?action=showpage&page=picturelist&appid=389652585C67EE8F0DCF9C7B92504D32&guest=s","type":3},{"url":"t.channel.45xie.com/api/api?action=showpage&page=videolist&appid=28BCB58E6C5D082E54B8DB52A7C71AF5&_pos=home&guest=s","type":4},{"url":"t.channel.45xie.com/api/api?action=showpage&page=picturelist&appid=A4FA187A9316083E2CB75F8DAC6C2BC6&_pos=home&guest=s","type":3},{"url":"t.channel.45xie.com/api/api?action=showpage&page=picturelist&appid=75433D1AF3F5DC7CBB64FA05E8C89C60&guest=s","type":3},{"url":"t.channel.45xie.com/api/api?action=showpage&page=picturelist&appid=34405B53D81E6E2FF9B8FFC81CDF9CF6&guest=s","type":3},{"url":"t.channel.45xie.com/api/api?action=showpage&page=picturelist&appid=1AFEA97FB6FC02B51DB4DC690560F50E&guest=s","type":3},{"url":"t.channel.45xie.com/api/api?action=showpage&page=picturelist&appid=32D3793AF7ED7C758710394704939C1E&guest=s","type":3},{"url":"t.channel.45xie.com/api/api?action=showpage&page=picturelist&appid=984A46DAA457B9CE1B3BC64B41682381&guest=s","type":3},{"url":"t.channel.45xie.com/api/api?action=showpage&page=index&_pos=home&appid=D9372F3FA907D1199BF5440F95982514","type":2},{"url":"t.channel.45xie.com/api/api?action=showpage&page=picturelist&appid=FB6A095DFD9135799FB998C00A37CDA4&guest=s","type":3},{"url":"t.channel.45xie.com/api/api?action=showpage&page=picturelist&appid=3D752ED186A4B772F54D382328A0D541&guest=s","type":3},{"url":"t.channel.45xie.com/api/api?action=showpage&page=picturelist&appid=BFC3E5A0B144AC29B1A642F64DF0ABC2&guest=s","type":3},{"url":"t.channel.45xie.com/api/api?action=showpage&page=picturelist&appid=A3E5D4F6D4AB0BD3230E57C18C17B5B6&guest=s","type":3},{"url":"t.channel.45xie.com/api/api?action=showpage&page=picturelist&appid=E2104773E3D7BF6DF373832B1AC23C4C&guest=s","type":3},{"url":"t.channel.45xie.com/api/api?action=showpage&page=picturelist&appid=169CF6A31520459ECD25FDC87E9AFB4A&guest=s","type":3},{"url":"t.channel.45xie.com/api/api?action=showpage&page=picturelist&id=10004&appid=B932496512C544D1D790E8572D5FCCE6&guest=s","type":3},{"url":"t.channel.45xie.com/api/api?action=showpage&page=picturelist&appid=FB55AB4CC45A14EDD50BC317A69833A0&guest=s","type":3},{"url":"t.channel.45xie.com/api/api?action=showpage&page=picturelist&appid=9990D2A5257DA8EAD3430B51BAD9293A&guest=s","type":3},{"url":"t.channel.45xie.com/api/api?action=showpage&page=picturelist&appid=8B0DFA0A60FF3F3901B2194C2B057706&guest=s","type":3},{"url":"t.channel.45xie.com/api/api?action=showpage&page=picturelist&appid=BDD3C9D2E70823A167EC505221304CF5&guest=s","type":3},{"url":"t.channel.45xie.com/api/api?action=showpage&page=videolist&appid=5F963A4CFF18B38CAC7762A78FC13850&_pos=home&guest=s","type":4},{"url":"t.channel.45xie.com/api/api?action=showpage&page=picturelist&appid=F58E3BEBBE5D7CF452E34C59FD97EB6C&_pos=home&guest=s","type":3},{"url":"t.channel.45xie.com/api/api?action=showpage&page=picturelist&appid=04980A033EE6843F2BDAD55ED1EC2DCF&_pos=home&guest=s","type":3},{"url":"t.channel.45xie.com/api/api?action=showpage&page=picturelist&appid=F4BB2F0E00DD5B264AB27D75D2F37766&_pos=home&guest=s","type":3},{"url":"t.channel.45xie.com/api/api?action=showpage&page=picturelist&appid=76C3D1460A90DCDE9E25A8B7D513E6D8&guest=s","type":3},{"url":"t.channel.45xie.com/api/api?action=showpage&page=videolist&appid=91E32CBD33F28C8CC7A475A7344574B5&_pos=home&guest=s","type":4},{"url":"ltxs50.mchannel.pipeline.letupower.cn","type":1},{"url":"ltxs51.mchannel.pipeline.letupower.cn","type":1},{"url":"ltxs52.mchannel.pipeline.letupower.cn","type":1},{"url":"t.channel.45xie.com/api/api?action=showpage&page=picturelist&appid=0EE6D3B4DF6EDAD1493A8E06CCE89133&guest=s","type":3},{"url":"t.channel.45xie.com/manhua/home.html?appid=E9121AF6F5633600943AA69DB667CFB9","type":1},{"url":"t.channel.45xie.com/manhua/home.html?appid=3E1FAA9D83FDD4047CB2C2329B1E6DB9","type":1}]
     */

    public String ret;
    public List<DataEntity> data;

    public static class DataEntity implements Serializable, Comparable<DataEntity> {
        /**
         * url : huitoutiao.pipeline.letupower.cn
         * type : 1
         */
        public int number;
        public String url;
        public int type;
        public String name;
        public int pv;
        public int uv;

        public DataEntity(int number, String url, String name, int pv, int uv) {
            this.number = number;
            this.url = url;
            this.name = name;
            this.pv = pv;
            this.uv = uv;
        }

        @Override
        public int compareTo(@NonNull DataEntity o) {
            int i = this.uv - o.uv;//先按uv排序
            if (i == 0) {
                return this.pv - o.pv;//如果uv相等了再用分数进行排序
            }
            return i;
        }
    }
}
