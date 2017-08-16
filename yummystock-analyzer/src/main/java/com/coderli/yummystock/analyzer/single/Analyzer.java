package com.coderli.yummystock.analyzer.single;

/**
 * 分析器
 * @param <I>
 * @param <O>
 */
public interface Analyzer<I, O> {

    O analyze(I input);

}
