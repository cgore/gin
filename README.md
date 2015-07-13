# gin

All of the generators!

Some people like a splash of [tonic](https://github.com/cgore/tonic) in their gin.

[![Clojars Project](http://clojars.org/gin/latest-version.svg)](http://clojars.org/gin)

[![Build Status](https://travis-ci.org/cgore/gin.svg?branch=master)](https://travis-ci.org/cgore/gin)

[![Dependencies Status](http://jarkeeper.com/cgore/gin/status.png)](http://jarkeeper.com/cgore/gin)

## Usage

### `gin.char`

You can generate lowercase characters.

```clojure
(gen/sample gin.char/alpha-lower)
;; => (\h \b \d \u \d \j \v \o \p \l)
```

You can generate uppercase characters.

```clojure
(gen/sample gin.char/alpha-upper)
;; => (\H \E \G \K \R \U \I \N \T \K)
```

You can generate numeric digit characters.

```clojure
(gen/sample gin.char/digit)
;; => (\3 \0 \0 \1 \9 \5 \1 \5 \6 \6)
```

You can generate hex number characters, in lowercase, uppercase, or mixed case.

```clojure
(gen/sample gin.char/hex-lower)
;; => (\5 \7 \3 \e \6 \5 \1 \5 \e \3)
(gen/sample gin.char/hex-upper)
;; => (\0 \1 \8 \9 \9 \5 \4 \A \F \9)
(gen/sample gin.char/hex)
;; => (\6 \3 \4 \1 \3 \8 \1 \2 \8 \F)
```

### `gin.core`

You can generate doubles (`java.lang.Double`).

```clojure
(gen/sample double)
;; => (0.0 -0.3044548010557556 0.3608557265686346 0.07745626015936646
;;    -0.5666316669335607 0.49643367918715875 2.8171573423013903
;;    -3.9887966759041404 -3.266237033535065 0.27244926994873986)
```

You can generate floats (`java.lang.Float`).

```clojure
(gen/sample float)
;; => (0.0 -0.8967302 -0.50622207 1.4199667 -2.7915213 0.31590796 -0.66204447
;;     0.0 -0.96169204 2.6542187)
```
### `gin.internet`

You can generate MAC addresses.

```clojure
(gen/sample mac-address)
;; => ("02:e4:f1:a6:54:82" "48:d2:73:2c:d6:f3" "cf:de:b9:13:52:64"
       "f6:10:b1:a7:25:bb" "0f:71:e2:ed:7b:63" "12:f5:a3:28:a0:49"
       "71:fd:53:09:8a:fa" "9d:66:b3:ae:df:a9" "e6:f9:3a:51:67:48"
       "73:51:b2:cf:69:50")
```

You can generate IPv4 addresses.

```clojure
(gen/sample ipv4-address)
;; => ("243.168.65.156" "245.123.138.81" "186.76.77.35"
;;     "42.199.195.232" "5.151.40.115"   "238.230.125.206"
;;     "188.165.164.43" "224.101.207.54" "65.101.97.133"
;;     "0.5.174.95")
```

You can generate IPv6 addresses.

```clojure
(gen/sample ipv6-address)
;; => ("4594:9283:449e:ce75:b0cd:325f:8acb:c229"
;;     "6459:58a1:7aed:63f9:3269:e038:ec3a:be8a"
;;     "5efa:9766:a34b:0832:8a2e:e2da:098a:93b6"
;;     "8bb6:0fdc:4877:b7f6:f750:e25e:bed7:f682"
;;     "40a2:f3f8:a837:f53a:3aec:492e:b960:737a"
;;     "ff5b:1a8e:66a3:3f7f:1af4:2f74:831d:54ed"
;;     "4368:5088:ea52:b9be:b841:484f:efc5:62f8"
;;     "e43c:a056:6270:66dd:c8c4:c9cf:0c33:069d"
;;     "3bda:a8b4:b7b2:a59e:06e3:88b7:f12b:98dd"
;;     "8323:5ba6:e935:d51e:66ef:c0f9:1a8a:e6ce")
```

You can even generate random URIs.
Please note that there are a lot more things that are valid URIs than seem obvious.

```clojure
(gen/sample uri)
;; => ("m:4wi/"
;;     "kz:h@55bi.hk1pd.92n#Q"
;;     "d0:i5dd:56559/?S5=79&Z=r1#c"
;;     "fpmz:Tya@qcz47.36jspfy.9qw-frh.17rqt8fk.ty3?z=7RC#jA"
;;     "y:iZwg@dmt3d.sg73o45.fl2:56060?ZCN=C1g&26a97=jYoN&X=gb0#zDA"
;;     "s:Q@li18t:15090?Vq2anw=3G7Hg&0MX=61FW0&C=EUU&n5=3OcF#b"
;;     "x:fuw8h.042d3nnp:26950/%c9-g/l%37%CB$l%B8?fYZgia=5&7ABf=5Y6y#kQTmiV"
;;     "t9xpovn:yKGvq:tFOuIMg@8u5xdkbh.vrohht4u:18957?8sv0Oi4=S2q3&S6uh=Gg83&2Lqo35=hA86&4KYiiAD=oYLF&Xol4=dCNQ1dv&AaQ=t#04ixTC"
;;     "o35n:sfXIkw@xiy.qpg1ngl4/?89wf=duh&8Cx4kB=L669&cuxTK=VpPX&VaBi2C=F1OZV4R0&dm006Ul=i&F1O4=Z&b28R4Wfj=g03XI0XR#78"
;;     "ps:RBdBWVpp:D@qijbq6-c.zlo4gw1.vwbmevg9.dez7ka4oplne)!+;/;(%3C%8a'/.r%26-~?qODZ=u4Grv7&VS2=u8sp2M5&e0BN=zn&1r58i=02&AkKx=JNrxPr47&W38Ygups=6u98520&jfqvz67TB=F1Z#3toKQdgY")
```

You can generate domain names.

```clojure
(gen/sample domain-name)
;; => ("et1" "zyed.ny-c" "09w.5nv7" "3ib" "zxfgbbg.p189qe2"
;;     "gw1lqd" "tc4.o6jqrq1h.2z289b88.ruiajhxe.8xxl8zxo"
;;     "8vh2z.6omq" "h5d6rj74.20107umxj.s7mfv3i5"
;;     "s8b0l76.m7niud25lg.q5r902pf2x.j61wv26b.d5ewzu")
```

### `gin.string`

You can generate lots of different strings.

You can restrict the string to only letters with `alpha`.

```clojure
(gen/sample alpha)
;; => ("" "" "Im" "" "vgS" "S" "ry" "tFROxf" "zzUKDEo" "XOIUr")
```
You can restrict the string to only lower-case letters with `alpha-lower`.

```clojure
(gen/sample alpha-lower)
;; => ("" "x" "om" "nbb" "" "tx" "p" "hmaj" "owdzu" "qkypmut")
```
You can restrict the string to only upper-case letters with `alpha-upper`.

```clojure
(gen/sample alpha-upper)
;; => ("" "D" "" "" "K" "QY" "DZWM" "GFJZLI" "BVGRNY" "YZUKLGQBD")
```

## License

Copyright © 2015 Christopher Mark Gore, Soli Deo Gloria, all rights reserved.

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
