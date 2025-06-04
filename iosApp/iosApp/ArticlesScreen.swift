package com.example.lab1

import swiftUI
import shared
extension ArticlesScreen {
    @MainActor
    class ArticlesViewModelWrapper: ObservableObject {
        let articlesViewModel: ArticlesViewModel

        @Published var articlesState: ArticlesState

        init() {
            articlesViewModel = ArticlesViewModel()
            articlesState = articlesViewModel.articlesState.value
        }


        func startObserving() {
            Task{
                for await articlesS in articlesViewModel.articlesState {
                    self.articlesState = articlesS
                }
            }
        }
    }
}

struct ArticlesScreen: View {

    @StateObject var viewModel = ArticlesViewModelWrapper()

    var body: some View {
        NavigationView {
            VStack {
                if viewModel.articlesState.loading {
                    ProgressView("Loading Articles...")
                } else if let error = viewModel.articlesState.error {
                    Text("Error: \(error)")
                } else if !viewModel.articlesState.articles.isEmpty {
                    List(viewModel.articlesState.articles, id: \.title) { article in
                        Text("Article:article.title")
                }
                }
            }
                .navigationTitle("Latest Articles")
                .onAppear {
                    self.viewModel.startObserving()
                }
        }
    }
}
