# cloverage-bug
Minimal setup for a java interop bug causing wrong function to be called.

## Usage

```bash
$ lein test

lein test cloverage-bug.core-test

Ran 2 tests containing 2 assertions.
0 failures, 0 errors.
```

```bash
$ lein cloverage
Loading namespaces:  (cloverage-bug.core user cloverage-bug.core)
Test namespaces:  (cloverage-bug.core-test)
Loaded  cloverage-bug.core  .
Loaded  user  .
Instrumented namespaces.

Testing cloverage-bug.core-test

ERROR in (perform-interop) (AFn.java:429)
expected: (instance? String (sut/perform-interop))
  actual: clojure.lang.ArityException: Wrong number of args (2) passed to: clojure.core/identity
 at clojure.lang.AFn.throwArity (AFn.java:429)
    clojure.lang.AFn.invoke (AFn.java:36)
    cloverage_bug.core$perform_interop.invokeStatic (cloverage_bug/core.clj:3)
    cloverage_bug.core$perform_interop.invoke (cloverage_bug/core.clj:1)
    cloverage_bug.core_test$fn__2971.invokeStatic (core_test.clj:7)
    cloverage_bug.core_test/fn (core_test.clj:6)
    clojure.test$test_var$fn__9707.invoke (test.clj:717)
    clojure.test$test_var.invokeStatic (test.clj:717)
    clojure.test$test_var.invoke (test.clj:708)
    clojure.test$test_vars$fn__9733$fn__9738.invoke (test.clj:735)
    clojure.test$default_fixture.invokeStatic (test.clj:687)
    clojure.test$default_fixture.invoke (test.clj:683)
    clojure.test$test_vars$fn__9733.invoke (test.clj:735)
    clojure.test$default_fixture.invokeStatic (test.clj:687)
    clojure.test$default_fixture.invoke (test.clj:683)
    clojure.test$test_vars.invokeStatic (test.clj:731)
    clojure.test$test_all_vars.invokeStatic (test.clj:737)
    clojure.test$test_ns.invokeStatic (test.clj:758)
    clojure.test$test_ns.invoke (test.clj:743)
    clojure.core$map$fn__5851.invoke (core.clj:2755)
    clojure.lang.LazySeq.sval (LazySeq.java:42)
    clojure.lang.LazySeq.seq (LazySeq.java:51)
    clojure.lang.Cons.next (Cons.java:39)
    clojure.lang.RT.boundedLength (RT.java:1788)
    clojure.lang.RestFn.applyTo (RestFn.java:130)
    clojure.core$apply.invokeStatic (core.clj:667)
    clojure.test$run_tests.invokeStatic (test.clj:768)
    clojure.test$run_tests.doInvoke (test.clj:768)
    clojure.lang.RestFn.applyTo (RestFn.java:137)
    clojure.core$apply.invokeStatic (core.clj:665)
    clojure.core$apply.invoke (core.clj:660)
    cloverage.coverage$eval2869$fn__2871$fn__2873$run_tests__2874.invoke (coverage.clj:157)
    cloverage.coverage$eval2869$fn__2871$fn__2873.invoke (coverage.clj:163)
    cloverage.coverage$run_main$fn__2907.invoke (coverage.clj:251)
    cloverage.coverage$form_for_suppressing_unselected_tests.invokeStatic (coverage.clj:54)
    cloverage.coverage$form_for_suppressing_unselected_tests.invoke (coverage.clj:32)
    cloverage.coverage$run_main.invokeStatic (coverage.clj:249)
    cloverage.coverage$run_main.invoke (coverage.clj:183)
    cloverage.coverage$run_project.invokeStatic (coverage.clj:285)
    cloverage.coverage$run_project.doInvoke (coverage.clj:281)
    clojure.lang.RestFn.invoke (RestFn.java:410)
    user$eval2915.invokeStatic (form-init1535498619358748929.clj:1)
    user$eval2915.invoke (form-init1535498619358748929.clj:1)
    clojure.lang.Compiler.eval (Compiler.java:7176)
    clojure.lang.Compiler.eval (Compiler.java:7166)
    clojure.lang.Compiler.load (Compiler.java:7635)
    clojure.lang.Compiler.loadFile (Compiler.java:7573)
    clojure.main$load_script.invokeStatic (main.clj:452)
    clojure.main$init_opt.invokeStatic (main.clj:454)
    clojure.main$init_opt.invoke (main.clj:454)
    clojure.main$initialize.invokeStatic (main.clj:485)
    clojure.main$null_opt.invokeStatic (main.clj:519)
    clojure.main$null_opt.invoke (main.clj:516)
    clojure.main$main.invokeStatic (main.clj:598)
    clojure.main$main.doInvoke (main.clj:561)
    clojure.lang.RestFn.applyTo (RestFn.java:137)
    clojure.lang.Var.applyTo (Var.java:705)
    clojure.main.main (main.java:37)

Ran 2 tests containing 2 assertions.
0 failures, 1 errors.
Ran tests.
Writing HTML report to: /Users/jeroen.dejong/Workspace/playground/cloverage-bug/target/coverage/index.html

|--------------------+---------+---------|
|          Namespace | % Forms | % Lines |
|--------------------+---------+---------|
| cloverage-bug.core |   90.00 |  100.00 |
|               user |  100.00 |  100.00 |
|--------------------+---------+---------|
|          ALL FILES |   90.91 |  100.00 |
|--------------------+---------+---------|
```


### Notes

 - removing `:dev` profile from `project.clj` fixes the problem.
 - removing the `(:require [cloverage-bug.core])` from `dev/user.clj` fixes the problem.
 - 
