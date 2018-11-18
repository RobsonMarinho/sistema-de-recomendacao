package br.com.alura;

import java.io.IOException;
import java.util.List;

import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.recommender.Recommender;

public class RecomendaProdutos {
	public static void main(String[] args) throws IOException, TasteException {
		DataModel produtos = new Recomendador().getModeloDeProdutos();
		Recommender recommender = new RecomendadorBuilder().buildRecommender(produtos);
		
		//User 1
		System.out.println("usuario 1");
		List<RecommendedItem> recommendations = recommender.recommend(1, 4);
		for (RecommendedItem recommendation : recommendations) {
			System.out.println(recommendation);
		}
		//User 3
		System.out.println("usuario 3");
		recommendations = recommender.recommend(3, 4);
		for (RecommendedItem recommendation : recommendations) {
			System.out.println(recommendation);
		}
		
		//User 4
		System.out.println("usuario 4");
		recommendations = recommender.recommend(4, 4);
		for (RecommendedItem recommendation : recommendations) {
			System.out.println(recommendation);
		}
	}
}
