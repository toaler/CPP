package org.bpt.cpp.dp;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

import junit.framework.TestCase;

public class MaximumSubsequenceProductTest extends TestCase {
	
	public void testInput() throws IOException {
		String in = 
		    "1 2 3 -999999\n" +
            "-5 -2 2 -30 -999999\n" + 
            "-8 -999999\n" +
            "-1 0 -2 -999999\n" +
            "-1 -2 0 -2 -3 -999999\n" +
            "0 -999999\n" +
            "1 -999999\n" +
            "-1 -999999\n" +
            "0 0 -999999\n" +
            "1 2 3 -999999\n" +
            "-1 2 3 -4 -999999\n" +
            "-1 2 -3 4 -5 6 -7 -999999\n" +
            "-22165 26479 -30519 20570 21926 5461 -21760 19738 36 27996 26762 -21056 30496 -27578 -6652 -27655 -20486 -31160 -28640 11541 14781 21432 23522 26284 -8197 -7811 3018 -28177 26892 14295 -31414 6973 10577 -3631 16027 27842 27069 0 -22384 -20330 0 16401 30008 30633 -14477 -30858 18218 -17872 2837 7162 -11021 17405 -2486 9615 13879 -28512 18646 -1848 1640 -19757 15290 25717 -7745 31105 12707 12384 18951 22423 -20775 -31483 0 15212 22839 0 -30427 -329 2251 -22681 -22867 -29718 26530 -10644 18488 -29655 -19421 -11108 -6057 -7607 17735 0 -9881 31161 19245 8341 -2859 -5528 6160 -24326 18318 -4336 -999999\n" +
            "-12322 -31146 23548 24491 16532 3482 13181 -21641 -17745 -5503 -20940 6887 16502 24447 -29545 -9168 18961 -13417 31742 -21060 -29726 7202 -20215 29383 -16062 -27474 28252 -18989 6329 1610 -31729 -18340 -10294 -1337 -30863 -9730 0 3394 -8002 15081 -22972 11779 23548 29783 -32501 -2386 18170 17087 -24231 0 -26651 -26379 -28607 -30161 21351 17374 -29223 17373 27731 6793 -21493 4524 20322 28483 17977 -16283 11095 15433 -5808 -4936 14355 -14502 -18488 -29311 4017 -16961 -29585 32613 17892 -14119 -27733 -482 22927 18969 -26169 -19027 -23717 -7768 5765 31088 -28227 -13999 -3537 -22907 25355 -962 -17921 13481 -14275 7573 -999999\n" +
            "8322 21717 -10797 -29791 20678 -6242 -5160 1168 28413 0 16393 -669 23285 0 9035 -19076 6160 16721 -14563 26099 -1460 3678 7577 23569 18219 -16947 17835 8024 30656 -24612 738 -14144 23251 11361 0 -18950 -5016 29529 25918 -14165 0 18555 -9183 29628 -342 21040 31547 -15098 23254 -19545 -9742 8273 -28635 -22595 14795 -2412 31055 -11644 10756 -8647 29249 17600 20869 -13497 -10401 25636 -14768 -30400 -4666 -30848 0 12844 20477 -29911 -25775 1171 0 -23297 2993 -16334 -16114 0 -4576 12891 -25672 -14711 -15353 -29261 6576 -32488 -3103 3660 27136 -26808 -22005 -16303 -22470 26824 3803 15235 -999999\n" +
            "-12292 27008 13550 -9724 28115 7259 5702 -24353 -13365 -28595 29803 -5298 0 -14174 32373 -18365 -15496 -2676 0 21579 23838 31103 -15289 9818 32038 -1544 -9397 11039 -29208 12825 -23786 570 -5824 -2784 -19083 21611 -1643 828 14674 -20608 32766 -20420 -13623 -27007 -26453 4632 2417 16916 -221 -24428 -8109 28989 17268 28241 15245 3123 -23680 0 -28961 -24436 0 -10194 26697 -5795 1310 -26326 11345 -4449 28457 30756 -20499 -6512 22024 16704 31188 19172 5089 -270 29024 -9080 -28119 24741 27271 30575 20263 -1877 30685 10185 8838 -32245 8621 1449 -26041 -28017 -23869 -3846 21364 -1172 0 4249 -999999\n" +
            "18193 -4599 27598 19215 0 24293 -6260 8487 -19551 -13394 -21763 -24006 -6237 1046 -24059 -12109 18970 -18668 -15543 -24140 -11028 -9073 2718 28017 6724 8947 -21398 1659 -8002 -4474 -8395 -10336 7064 -3863 10145 700 13925 2156 22774 10876 -24118 21628 -19612 5067 32032 -1459 17686 -32060 -15137 -14904 18321 14393 -27320 -30578 1061 31403 -31683 -23767 2636 -9706 -4248 -14844 1442 -12007 4453 21466 -32478 5015 0 26605 -26811 28362 2613 31378 14806 15011 32714 -21234 5682 3330 -20078 -8478 -8786 -2775 -28936 -3332 13775 -18614 -23259 26582 -13559 10090 17603 -22199 8355 30649 30385 -25255 -30808 -29049 -999999\n" +
            "-18788 6576 -19105 -18899 -23657 11601 -4011 29909 -15444 -14890 -10785 24126 30015 -9449 -10825 -9604 -19843 -14452 -12128 10538 9397 -29015 -817 -27968 -13028 8815 19452 -10554 9232 24279 -28805 2293 -19437 21778 -2682 -27910 28120 -1914 777 -13893 -21785 -3560 -13761 26778 -14682 19620 13737 0 29382 -10129 -15436 260 19117 5627 17800 23888 22068 -8221 -13429 -10896 6712 -19371 16680 -5916 25393 0 -13137 -15130 -9496 25324 -8960 29201 -25391 -10921 -23105 7062 11877 3217 5015 -16757 4401 -11126 27531 -31295 19568 -22570 -23426 -17426 -21479 16493 -22235 0 31723 15610 5624 9732 19073 2566 -12229 2325 -999999\n" +
            "14818 15694 6475 19563 31299 -27199 -14388 -28500 28147 3605 26703 -13900 -29311 -10724 -19531 30503 -26632 -19436 -25269 -12927 -4834 0 86 -16361 8707 -4015 -2462 -1005 -1457 15065 10692 -1520 -32205 -25042 9342 4196 -16465 24939 -27995 13602 14933 8569 -13659 11768 29002 0 -16537 14210 7390 28552 -30249 -22778 -24117 -20453 16801 32064 -18458 22120 2121 5154 -7559 17545 452 14514 -30760 -23023 -25935 -15346 14392 22595 -4921 5316 18074 -23098 30370 24849 -1338 18908 7032 -25656 2470 -538 -13485 11961 -32231 -26511 3773 23330 17317 -1173 -10847 3128 13690 0 -25882 16769 -18628 13980 27475 19603 -999999\n" +
            "-433 -7498 -30936 -28318 0 -1770 13581 -26849 -27583 -2357 -11289 14258 -12863 -32450 23706 -692 -18981 21246 20040 -970 16947 -21803 42 -31434 12111 4591 0 12900 -27495 -9815 17161 -32003 8541 30594 8540 -31216 11699 9999 16637 -7921 20591 0 -26960 5887 -10148 28335 10399 12415 23465 29968 9871 21773 1959 -25583 -31115 -2974 7048 -5478 11795 -25089 21729 30104 22648 -24080 24397 26879 23253 27674 -16137 -24058 -6992 30351 25041 -21910 -9874 -4844 -29177 -28571 -31363 28649 -18382 17882 30026 28897 -5422 -8884 9348 -8833 10085 24302 28867 29875 -23370 29363 -24905 26061 -8090 1514 -29701 2805 -999999\n" +
            "-8596 3001 -17869 8663 -32725 13657 -1757 6026 0 -31665 -19954 26547 842 -5368 23813 -5944 13439 7857 -32184 -19599 -16013 -10306 18678 12222 31511 0 -14527 7512 -16947 -19532 -4526 -13068 29936 12194 -888 -14259 -6956 30546 -26104 0 -27883 23408 3600 12039 0 6941 0 -20464 -24219 11431 -16028 -29999 13184 27392 4429 24637 -6102 -12308 0 -10022 -16639 -833 -7922 -3268 19244 18910 10297 3979 15974 5264 12697 1176 12304 -15840 -32627 26934 -16323 3895 -21509 0 -454 28048 14783 -27461 18608 20083 26882 6408 -12764 7686 21237 26077 -30033 -31716 -484 -26475 -27515 -22548 -19350 -16501 -999999\n" +
            "-14821 2870 21674 -5668 1078 31729 11824 0 0 -8053 -23174 -1922 28125 0 -30049 -21546 -15989 21760 -15987 2394 8076 -4189 -1941 0 -8888 -27348 -31865 -2906 -8912 17825 0 9817 -26408 -30111 -22781 -15338 16383 -3966 5105 -398 -17324 11788 0 29911 19947 24348 -17462 12152 20698 28953 -1543 -28242 18164 18705 30199 -7052 24827 -4051 24314 -30803 -12632 3180 4641 -21410 -29852 20247 -28600 -25679 -8757 -15722 11936 0 -31479 -10539 0 602 -16662 -9148 5914 -16332 -26848 12412 -22308 -27516 -11276 23889 -31477 25224 28260 -12357 -21284 -13486 7143 -19678 -6932 0 0 -27820 11178 -21790 -999999\n" +
            "99900 99901 99902 99903 99904 99905 99906 99907 99908 99909 99910 99911 99912 99913 99914 99915 99916 99917 99918 99919 99920 99921 99922 99923 99924 99925 99926 99927 99928 99929 99930 99931 99932 99933 99934 99935 99936 99937 99938 99939 99940 99941 99942 99943 99944 99945 99946 99947 99948 99949 99950 99951 99952 99953 99954 99955 99956 99957 99958 99959 99960 99961 99962 99963 99964 99965 99966 99967 99968 99969 99970 99971 99972 99973 99974 99975 99976 99977 99978 99979 99980 99981 99982 99983 99984 99985 99986 99987 99988 99989 99990 99991 99992 99993 99994 99995 99996 99997 99998 99999 -999999";
		
		InputStreamReader isr = new InputStreamReader(new ByteArrayInputStream(in.getBytes()));
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(baos);

		MaximumSubsequenceProduct.mainWork(new BufferedReader(isr), ps);
		
		String out =
				"6\n" + 
			    "120\n" + 
                "-8\n" + 
                "0\n" +
                "6\n" +
                "0\n" +
                "1\n" +
                "-1\n" +
                "0\n" +
                "6\n" +
                "24\n" +
                "5040\n" +
                "660186924239300256381331965323884123873139906107331665003767312706724979159613907582932273035154653533755587464919791869709718460459040781631488000000\n" +
                "6355560515408507362219170874059270132704493845218762747178041418961748542996137556871354827133525531059205389180298673935708618324452505879348190709889774752594581051538872881382560943640893145738117120000000\n" +
                "1229556356276566700688120448874948287779852414764266483733354720315268895704334831375446375513723353093583667200000000000\n" +
                "148145008991443564691425237116514446573916621976027617080411504174283740339788649727781333741254885659696913661447305265331428326923902857833873408000000\n" +
                "2419441812276434370864857986522664117329216166463717838690027606303743023681089339896893297338473333122864934955436115986232376504861595470429145033350623321320866424363292680929903765672699250536968094209137835964043934023930215653363941376000000000000\n" +
                "22883970382617495241466466478795923488314338164748097500630109045177339572256803048946032246085652882746890496670809428753662281687280346794087564999491679393082101419789516800000000000000\n" +
                "1117984860563396802973841750545641928238064132554190192024113442440893015392223312998823609111883539956548997305668096781653150238943192716129363270212836598139288620697124864000000000000\n" +
                "46488791307504980095808885780656216406273082607273964872648172970572968594055539306884883780978407049848001128961722222122569647582775501439753896263218688375580964768009778065215934341978907551071378568839935986870763126784000000000000000\n" +
                "96284946097802076178041482872981052895428626344934586000760301922703074918400000\n" +
                "6807191240356465934497464421360453774160405998158666609044829647508500903382879498959387161950195076300800000\n" + 
                "95073783634185106058480752069956279199041805151309597685850804143872493687225762724265298696680866720060438572638872338185423558516745575068148747617495637233246533038583138313941279391299861732093898219130183367516764321276544576375955285875947586351401575501779450726582846893999985310435777036870171150461994629508009325776347750386998738990303339348062610266452782201995528321494110278961303062035131223129701746286517127149552121601906172064292436146016461554458887716864000000000000000000000000\n";
		
		assertEquals(out, baos.toString()); 
	}
}