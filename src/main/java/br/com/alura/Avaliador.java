package br.com.alura;

import java.io.IOException;

import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.eval.RecommenderBuilder;
import org.apache.mahout.cf.taste.eval.RecommenderEvaluator;
import org.apache.mahout.cf.taste.impl.eval.AverageAbsoluteDifferenceRecommenderEvaluator;
import org.apache.mahout.cf.taste.model.DataModel;

public class Avaliador {

	public static void main(String[] args) throws IOException, TasteException {
		// aleatóriedade
		org.apache.mahout.common.RandomUtils.useTestSeed();

		// Pega um modelo de curso
		DataModel modelo = new Recomendador().getModeloDeCursos();

		// Tenta calcular todas a diferenças
		RecommenderEvaluator evaluator = new AverageAbsoluteDifferenceRecommenderEvaluator();
		RecommenderBuilder builder = new RecomendadorBuilder();
		double erro = evaluator.evaluate(builder, null, modelo, 0.9, 1.0);
		System.out.println(erro); // Exibe a margem de erro

	}
}
