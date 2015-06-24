# gin

All of the generators!



[![Clojars Project](http://clojars.org/gin/latest-version.svg)](http://clojars.org/gin)

[![Build Status](https://travis-ci.org/cgore/gin.svg?branch=master)](https://travis-ci.org/cgore/gin)

## Usage

### `gin.core`

You can generate doubles (`java.lang.Double`).

```clojure
(gen/sample double)
;; => (0.0 -0.3044548010557556 0.3608557265686346 0.07745626015936646
;;    -0.5666316669335607 0.49643367918715875 2.8171573423013903
;;    -3.9887966759041404 -3.266237033535065 0.27244926994873986)

You can generate floats (`java.lang.Float`).

```clojure
(gen/sample float)
;; => (0.0 -0.8967302 -0.50622207 1.4199667 -2.7915213 0.31590796 -0.66204447
;;     0.0 -0.96169204 2.6542187)
```

### `gin.string`

You can generate lots of different strings.

You can restrict the string to only letters with `string-alpha`.

```clojure
(gen/sample string-alpha)
;; => ("" "" "Im" "" "vgS" "S" "ry" "tFROxf" "zzUKDEo" "XOIUr")
```
You can restrict the string to only lower-case letters with `string-alpha-lower`.

```clojure
(gen/sample string-alpha-lower)
;; => ("" "x" "om" "nbb" "" "tx" "p" "hmaj" "owdzu" "qkypmut")
```
You can restrict the string to only upper-case letters with `string-alpha-upper`.

```clojure
(gen/sample string-alpha-upper)
;; => ("" "D" "" "" "K" "QY" "DZWM" "GFJZLI" "BVGRNY" "YZUKLGQBD")
```

## License

Copyright © 2015 Christopher Mark Gore, Soli Deo Gloria, all rights reserved.

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
